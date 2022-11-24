package com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate

import com.dmitriy.phonetesttask.R
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.cart.adapters.BasketAdapter
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.cart.items.CartCardItem
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.cart.items.CartItem
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.cart.items.CartProgressCardItem
import com.dmitriy.phonetesttask.databinding.ItemCartBinding
import com.dmitriy.phonetesttask.databinding.ItemCartCardBinding
import com.dmitriy.phonetesttask.databinding.ItemCartProgressBinding
import com.dmitriy.base.core.utils.Downloader
import com.dmitriy.phonetesttask.app.controllers.CartController
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn

object CartScreenDelegates {

    fun cartItem() = adapterDelegateViewBinding<CartItem, ListItem, ItemCartBinding>(
        { layoutInflater, parent ->
            ItemCartBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        val adapter = BasketAdapter()
        binding.recyclerView.adapter = adapter

        bind {
            observeGetTotalPrice {
                binding.totalPriceTextView.text = context.getString(
                    R.string.total_price,
                    it.toString()
                )
            }
            adapter.items = item.items
        }
    }

    fun cartCardItem() = adapterDelegateViewBinding<CartCardItem, ListItem, ItemCartCardBinding>(
        { layoutInflater, parent ->
            ItemCartCardBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        val cartCardController = CartCardController(binding)

        bind {
            cartCardController.price = item.price

            binding.apply {
                titleTextView.text = item.title
                priceTextView.text = context.getString(R.string.price_3000_00, item.price.toString())
                addItemFrameLayout.setOnClickListener { cartCardController.addItem() }
                removeItemFrameLayout.setOnClickListener { cartCardController.removeItem() }
                trashImageView.setOnClickListener { cartCardController.resetItems() }

                Downloader()
                    .load(item.image)
                    .into(phoneImageView)
            }
        }
    }

    fun cartProgressItem() = adapterDelegateViewBinding<CartProgressCardItem, ListItem, ItemCartProgressBinding>(
        { layoutInflater, parent ->
            ItemCartProgressBinding.inflate(layoutInflater, parent, false)
        }
    ) { }

    private fun observeGetTotalPrice(listener: (Int) -> (Unit)) = CartController.getTotalPriceEvent.map {
        listener.invoke(it)
    }.shareIn(CoroutineScope(Dispatchers.Main), SharingStarted.Eagerly)

    class CartCardController(
        private val binding: ItemCartCardBinding
    ) {

        var price: Int = 0

        var countItems: Int = 0
            private set

        fun addItem() {
            countItems += 1
            CartController.addProduct(price)
            updateUI()
        }

        fun removeItem() {
            if (countItems <= 0) return

            countItems -= 1
            CartController.removeProduct(price)
            updateUI()
        }

        fun resetItems() {
            if (countItems <= 0) return

            CartController.resetProducts(price, countItems)
            countItems = 0
            updateUI()
        }

        private fun updateUI() {
            binding.countItemsTextView.text = countItems.toString()
        }
    }
}
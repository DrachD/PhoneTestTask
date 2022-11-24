package com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate

import android.annotation.SuppressLint
import android.view.View
import androidx.core.content.ContextCompat
import com.dmitriy.phonetesttask.app.screens.main.MainActivity
import com.dmitriy.phonetesttask.R
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.home.adapters.BestSellerAdapter
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.home.adapters.HotSalesAdapter
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.home.adapters.SelectCategoryAdapter
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.home.items.*
import com.dmitriy.phonetesttask.app.controllers.SelectCategory
import com.dmitriy.phonetesttask.databinding.*
import com.dmitriy.base.core.utils.Downloader
import com.dmitriy.phonetesttask.app.utils.findTopNavController
import com.dmitriy.phonetesttask.databinding.ItemHotSalesBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object HomeScreenDelegates {

    @SuppressLint("StaticFieldLeak")
    private var bindingSelected: ItemSelectCategoryCardBinding? = null

    @SuppressLint("NotifyDataSetChanged")
    fun selectCategoryItem() = adapterDelegateViewBinding<SelectCategoryItem, ListItem, ItemSelectCategoryBinding>(
        { layoutInflater, parent ->
            ItemSelectCategoryBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        val activity = binding.root.context as MainActivity

        val adapter = SelectCategoryAdapter()
        binding.recyclerView.adapter = adapter

        bind {
            adapter.apply {
                items = item.items
                notifyDataSetChanged()
            }
            binding.dashboardButton.setOnClickListener {
                activity.findTopNavController().navigate(R.id.action_tabsFragment_to_cartFragment)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun hotSalesItem() = adapterDelegateViewBinding<HotSalesItem, ListItem, ItemHotSalesBinding>(
        { layoutInflater, parent ->
            ItemHotSalesBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        val adapter = HotSalesAdapter()
        binding.hotSalesRecyclerView.adapter = adapter
        //binding.viewPager.adapter = adapter

        bind {
            adapter.apply {
                items = item.items
                notifyDataSetChanged()
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun bestSellerItem() = adapterDelegateViewBinding<BestSellerItem, ListItem, ItemBestSellerBinding>(
        { layoutInflater, parent ->
            ItemBestSellerBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        val adapter = BestSellerAdapter()
        binding.bestSellerRecyclerView.adapter = adapter

        bind {
            adapter.apply {
                items = item.items
                notifyDataSetChanged()
            }
        }
    }

    fun hotSalesProgressItem() = adapterDelegateViewBinding<HotSalesProgressItem, ListItem, ItemHotSalesProgressBinding>(
        { layoutInflater, parent ->
            ItemHotSalesProgressBinding.inflate(layoutInflater, parent, false)
        }
    ) { }

    fun hotSalesCardItem() = adapterDelegateViewBinding<HotSalesCardItem, ListItem, ItemHotSalesCardBinding>(
        { layoutInflater, parent ->
            ItemHotSalesCardBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        val activity = binding.root.context as MainActivity

        bind {
            binding.titleTextView.text = item.title
            binding.subtitleTextView.text = item.subtitle
            binding.newImageView.visibility = if (item.isNew) View.VISIBLE else View.INVISIBLE
            binding.buyNowFrameLayout.setOnClickListener {
                activity.findTopNavController().navigate(R.id.action_tabsFragment_to_detailsFragment)
            }

            Downloader()
                .load(item.image)
                .into(binding.pictureImageView)
        }
    }

    fun bestSellerProgressItem() = adapterDelegateViewBinding<BestSellerProgressItem, ListItem, ItemBestSellerProgressBinding>(
        { layoutInflater, parent ->
            ItemBestSellerProgressBinding.inflate(layoutInflater, parent, false)
        }
    ) { }

    fun bestSellerCardItem() = adapterDelegateViewBinding<BestSellerCardItem, ListItem, ItemBestSellerCardBinding>(
        { layoutInflater, parent ->
            ItemBestSellerCardBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        val activity = binding.root.context as MainActivity
        var isFavorite: Boolean = false

        bind {
            binding.apply {
                brandPhoneTextView.setText(item.brand)
                newPriceTextView.setText(item.newPrice)
                oldPriceTextView.setText(item.oldPrice)
                phoneImageView.setImageResource(item.image)
                buyPhoneCardView.setOnClickListener {
                    activity.findTopNavController().navigate(R.id.action_tabsFragment_to_detailsFragment)
                }
                favoriteFAB.setOnClickListener {
                    isFavorite = if (isFavorite) {
                        favoriteFAB.setImageResource(R.drawable.ic_like)
                        false
                    } else {
                        favoriteFAB.setImageResource(R.drawable.ic_like_full)
                        true
                    }
                }
            }
        }
    }

    fun selectCategoryCardItem() = adapterDelegateViewBinding<SelectCategoryCardItem, ListItem, ItemSelectCategoryCardBinding>(
        { layoutInflater, parent ->
            ItemSelectCategoryCardBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        bind {
            val selectCategoryItem = SelectCategory.list[layoutPosition]

            binding.apply {
                categoryTextView.setText(item.category)
                iconCategoryImageView.setImageResource(item.image)
                initSelectedCategory(selectCategoryItem, this@apply)

                categoryCardView.setOnClickListener {
                    onSelectedItem(this@apply)
                }
            }
        }
    }

    private fun initSelectedCategory(
        selectCategoryItem: SelectCategory.SelectCategoryData,
        binding: ItemSelectCategoryCardBinding
    ) {
        val resources = binding.root.resources
        val context = binding.root.context

        if (selectCategoryItem.positionSelected == SelectCategory.positionSelected) {
            bindingSelected = binding
            binding.categoryCardView.setCardBackgroundColor(ContextCompat.getColor(context, SelectCategory.backgroundColorSelected))
            binding.iconCategoryImageView.setColorFilter(resources.getColor(SelectCategory.colorTintSelected))
            binding.categoryTextView.setTextColor(ContextCompat.getColor(binding.root.context, SelectCategory.textColorSelected))
        } else {
            binding.categoryCardView.setCardBackgroundColor(ContextCompat.getColor(context, SelectCategory.backgroundColorUnselected))
            binding.iconCategoryImageView.setColorFilter(context.resources.getColor(SelectCategory.colorTintUnselected))
            binding.categoryTextView.setTextColor(ContextCompat.getColor(context, SelectCategory.textColorUnselected))
        }
    }

    private fun onSelectedItem(
        binding: ItemSelectCategoryCardBinding
    ) {
        val context = binding.root.context

        bindingSelected?.apply {
            categoryCardView.setCardBackgroundColor(ContextCompat.getColor(context, SelectCategory.backgroundColorUnselected))
            iconCategoryImageView.setColorFilter(context.resources.getColor(SelectCategory.colorTintUnselected))
            categoryTextView.setTextColor(ContextCompat.getColor(context, SelectCategory.textColorUnselected))
        }

        binding.apply {
            binding.categoryCardView.setCardBackgroundColor(ContextCompat.getColor(context, SelectCategory.backgroundColorSelected))
            binding.iconCategoryImageView.setColorFilter(context.resources.getColor(SelectCategory.colorTintSelected))
            binding.categoryTextView.setTextColor(ContextCompat.getColor(context, SelectCategory.textColorSelected))

        }

        bindingSelected = binding
    }
}
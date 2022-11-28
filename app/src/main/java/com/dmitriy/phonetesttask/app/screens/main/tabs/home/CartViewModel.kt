package com.dmitriy.phonetesttask.app.screens.main.tabs.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dmitriy.phonetesttask.app.model.phones.PhoneRepository
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.cart.items.CartCardItem
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.cart.items.CartItem
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.cart.items.CartProgressCardItem
import com.dmitriy.base.core.utils.GeneralResponse
import com.dmitriy.phonetesttask.app.di.ActivityScope
import com.dmitriy.phonetesttask.app.screens.base.CoreViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@ActivityScope
class CartViewModel @Inject constructor(
    private val phoneRepository: PhoneRepository
) : CoreViewModel() {

    private val _data = MutableLiveData<List<ListItem>>()
    val data: LiveData<List<ListItem>> = _data

    init {
        viewModelScope.launch {
            _data.postValue(getLoaders())
            _data.postValue(getItems())
        }
    }

    private fun getLoaders(): List<ListItem> {
        return listOf(
            CartItem(
                items = IntRange(1, 2).map { CartProgressCardItem }
            )
        )
    }

    private suspend fun getItems(): List<ListItem> {
        val basketListResponse = fetchBasketList()
        hideProgress()

        return listOf(
            CartItem(
                basketListResponse.ifEmpty {
                    IntRange(1, 2).map { CartProgressCardItem }
                }
            )
        )
    }

    private suspend fun fetchBasketList(): List<ListItem> {
        showProgress()
        when (val response = phoneRepository.fetchBasketList()) {
            is GeneralResponse.Success -> {

                val cartCardItems = response.data!!.basket.map {
                    CartCardItem(
                        id = it.id,
                        title = it.title,
                        price = it.price,
                        image = it.images
                    )
                }

                return cartCardItems
            }
            is GeneralResponse.Error -> {
                showMessage(response.errorMessage, response.code)
                return emptyList()
            }
        }
    }
}
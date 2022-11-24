package com.dmitriy.phonetesttask.app.screens.main.tabs.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dmitriy.phonetesttask.app.model.phones.PhoneRepository
import com.dmitriy.phonetesttask.R
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem
import com.dmitriy.phonetesttask.app.model.phones.entities.BestSellerList
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.home.items.*
import com.dmitriy.base.core.utils.GeneralResponse
import com.dmitriy.phonetesttask.app.screens.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val phoneRepository: PhoneRepository
) : BaseViewModel() {

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
            SelectCategoryItem(fetchListCategory()),
            HotSalesItem(
                items = IntRange(1, 4).map { HotSalesProgressItem }
            ),
            BestSellerItem(fetchListBestSeller())
        )
    }

     private suspend fun getItems(): List<ListItem> {
         val selectCategoryResponse = fetchListCategory()
         val hotSalesResponse = fetchListPhones()
         val bestSellerResponse = fetchListBestSeller()
         hideProgress()

         return listOf(
             SelectCategoryItem(selectCategoryResponse),
             HotSalesItem(hotSalesResponse),
             BestSellerItem(bestSellerResponse)
         )
    }

    private fun fetchListCategory(): List<ListItem> = listOf(
        SelectCategoryCardItem(0, R.string.phones, R.drawable.ic_phones),
        SelectCategoryCardItem(1, R.string.computer, R.drawable.ic_computer),
        SelectCategoryCardItem(2, R.string.health, R.drawable.ic_health),
        SelectCategoryCardItem(4, R.string.books, R.drawable.ic_books),
        SelectCategoryCardItem(5, R.string.something, R.drawable.ic_something)
    )

    private fun fetchListBestSeller(): List<ListItem> = BestSellerList().list.map {
        BestSellerCardItem(
            id = it.id,
            brand = it.brand,
            newPrice = it.newPrice,
            oldPrice = it.oldPrice,
            image = it.image
        )
    }

    private suspend fun fetchListPhones(): List<ListItem> {

        showProgress()
        when (val response = phoneRepository.fetchListPhones()) {
            is GeneralResponse.Success -> {

                val cardHotSalesItem = response.data!!.home_store.map {
                    HotSalesCardItem(
                        id = it.id,
                        title = it.title,
                        subtitle = it.subtitle,
                        image = it.picture,
                        isNew = it.is_new,
                        isBuy = it.is_buy
                    )
                }

                return cardHotSalesItem
            }
            is GeneralResponse.Error -> {
                showMessage(response.errorMessage, response.code)
                return emptyList()
            }
        }
    }
}
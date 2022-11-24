package com.dmitriy.phonetesttask.app.screens.main.tabs.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dmitriy.phonetesttask.app.model.phones.PhoneRepository
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.details.items.*
import com.dmitriy.base.core.utils.GeneralResponse
import com.dmitriy.phonetesttask.app.screens.base.CoreViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsViewModel @Inject constructor(
    private val phoneRepository: PhoneRepository
) : CoreViewModel() {

    private val _data = MutableLiveData<List<ListItem>>()
    val data: LiveData<List<ListItem>> = _data

    init {
        viewModelScope.launch {
            _data.postValue(getLoaders())
            delay(1000)
            _data.postValue(getItems())
        }
    }


    private fun getLoaders(): List<ListItem> {

        return listOf(
            ImageItem(
                items =IntRange(1, 2).map { ImageProgressCardItem }
            ),
            InfoItem(
                items = IntRange(1, 1).map { InfoProgressCardItem }
            )
        )
    }

    private suspend fun getItems(): List<ListItem> {
        hideProgress()
        return fetchPhoneDetails()
    }

    private suspend fun fetchPhoneDetails(): List<ListItem> {
        showProgress()
        when (val response = phoneRepository.fetchPhoneDetails()) {
            is GeneralResponse.Success -> {

                val data = response.data!!

                val detailsImageCardItems = data.images.map {
                    ImageCardItem(it)
                }

                val detailsInfoCardItems = listOf(
                    InfoCardItem(
                        id = data.id,
                        title = data.title,
                        cpu = data.CPU,
                        camera = data.camera,
                        ssd = data.ssd,
                        sd = data.sd,
                        colors = data.color
                    )
                )

                return listOf(
                    ImageItem(
                        detailsImageCardItems.ifEmpty {
                            IntRange(1, 2).map { ImageProgressCardItem }
                        }
                    ),
                    InfoItem(
                        detailsInfoCardItems.ifEmpty {
                            IntRange(1, 1).map { InfoProgressCardItem }
                        }
                    )
                )
            }
            is GeneralResponse.Error -> {
                showMessage(response.errorMessage, response.code)
                return listOf(
                    ImageItem(
                        IntRange(1, 2).map { ImageProgressCardItem }
                    ),
                    InfoItem(
                        IntRange(1, 1).map { InfoProgressCardItem }
                    )
                )
            }
        }
    }
}
package com.dmitriy.phonetesttask.app.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dmitriy.phonetesttask.app.screens.main.tabs.home.DetailsViewModel
import com.example.domain.repository.RetrofitPhoneRepository
import javax.inject.Inject

class DetailsViewModelFactory @Inject constructor(
    private val repository: RetrofitPhoneRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailsViewModel(repository) as T
    }
}
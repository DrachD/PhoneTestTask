package com.dmitriy.phonetesttask.app.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dmitriy.phonetesttask.app.model.phones.PhoneRepository
import com.dmitriy.phonetesttask.app.screens.main.tabs.home.HomeViewModel
import javax.inject.Inject

class HomeViewModelFactory @Inject constructor(
    private val repository: PhoneRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}
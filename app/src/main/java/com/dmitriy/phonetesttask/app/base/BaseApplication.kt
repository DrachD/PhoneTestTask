package com.dmitriy.phonetesttask.app.base

import android.app.Application
import com.dmitriy.phonetesttask.app.di.component.AppComponent
import com.dmitriy.phonetesttask.app.di.component.DaggerAppComponent

class BaseApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create()
    }
}
package com.dmitriy.phonetesttask.app.base

import android.app.Application
import com.dmitriy.phonetesttask.app.di.component.AppComponent
import com.dmitriy.phonetesttask.app.di.component.DaggerAppComponent

class CoreApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create()
    }
}
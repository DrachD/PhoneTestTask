package com.dmitriy.phonetesttask.app.base

import android.app.Application
import com.dmitriy.phonetesttask.app.di.component.AppComponent
import com.dmitriy.phonetesttask.app.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class CoreApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}
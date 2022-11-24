package com.dmitriy.phonetesttask.app.base

import android.app.Application
import com.dmitriy.phonetesttask.app.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class CoreApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var inject: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .build()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return inject
    }
}
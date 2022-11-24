package com.dmitriy.phonetesttask.app

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.dmitriy.phonetesttask.app.screens.main.MainActivity
import com.dmitriy.phonetesttask.R

fun Activity.findTopNavController(): NavController {
    val navHost = (this as MainActivity).supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
    return navHost.navController
}
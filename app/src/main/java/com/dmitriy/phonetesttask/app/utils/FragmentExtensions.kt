package com.dmitriy.phonetesttask.app

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.dmitriy.phonetesttask.R

fun Fragment.findTopNavController(): NavController {
    val navHost = requireActivity().supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
    return navHost.navController
}
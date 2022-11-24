package com.dmitriy.phonetesttask.app.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.dmitriy.phonetesttask.R
import com.dmitriy.phonetesttask.databinding.ActivityMainBinding
import com.dmitriy.phonetesttask.app.screens.main.tabs.TabsFragment

class MainActivity : AppCompatActivity() {

    interface BaseLifecycleCallback {

        fun onFragmentViewCreated(
            fm: FragmentManager,
            f: Fragment,
            v: View,
            savedInstanceState: Bundle?
        )
    }

    private var callback: BaseLifecycleCallback? = null
    private var binding: ActivityMainBinding? = null
    private var navController: NavController? = null

    private val fragmentListener = object : FragmentManager.FragmentLifecycleCallbacks() {

        override fun onFragmentViewCreated(
            fm: FragmentManager,
            f: Fragment,
            v: View,
            savedInstanceState: Bundle?
        ) {
            super.onFragmentViewCreated(fm, f, v, savedInstanceState)

            if (f is TabsFragment) {
                if (callback != null) { return }
                callback = f
            }

            callback?.onFragmentViewCreated(fm, f, v, savedInstanceState)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
        }

        val navController = rootNavController()
        prepareRootNavController(navController)
        this.navController = navController

        supportFragmentManager.registerFragmentLifecycleCallbacks(fragmentListener, true)
    }

    override fun onDestroy() {
        supportFragmentManager.unregisterFragmentLifecycleCallbacks(fragmentListener)
        binding = null
        super.onDestroy()
    }

    private fun rootNavController(): NavController {
        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        return navHost.navController
    }

    private fun prepareRootNavController(navController: NavController) {
        val graph =  navController.navInflater.inflate(getMainGraphNavigation())
        graph.setStartDestination(getSplashDestination())
        navController.graph = graph
    }

    private fun getSplashDestination() = R.id.splashFragment
    private fun getMainGraphNavigation() = R.navigation.main_graph
    private fun getTabsGraphNavigation() = R.navigation.tabs_graph
}
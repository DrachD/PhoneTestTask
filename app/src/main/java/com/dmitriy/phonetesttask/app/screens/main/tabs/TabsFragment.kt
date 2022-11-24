package com.dmitriy.phonetesttask.app.screens.main.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.dmitriy.phonetesttask.app.screens.main.MainActivity
import com.dmitriy.phonetesttask.R
import com.dmitriy.phonetesttask.databinding.FragmentTabsBinding
import com.dmitriy.phonetesttask.app.screens.main.splash.SplashFragment

class TabsFragment : Fragment(R.layout.fragment_tabs), MainActivity.BaseLifecycleCallback {

    private var _binding: FragmentTabsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navHost = childFragmentManager.findFragmentById(R.id.tabsContainer) as NavHostFragment
        val navController = navHost.navController
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController)

        navController.currentBackStackEntry
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onFragmentViewCreated(
        fm: FragmentManager,
        f: Fragment,
        v: View,
        savedInstanceState: Bundle?
    ) {

        f.findNavController().backQueue.forEach {
            if (f is TabsFragment || f is NavHostFragment || f is SplashFragment) { return }

            when(it.destination.id) {
                getHomeDestination() -> binding.categoryTextView.setText(R.string.explorer)
                getFavoriteDestination() -> binding.categoryTextView.setText(R.string.favorite)
                getPersonDestination() -> binding.categoryTextView.setText(R.string.person)
            }
        }
    }

    private fun getHomeDestination() = R.id.homeFragment
    private fun getFavoriteDestination() = R.id.favoriteFragment
    private fun getPersonDestination() = R.id.personFragment
}
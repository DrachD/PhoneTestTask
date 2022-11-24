package com.dmitriy.phonetesttask.app.screens.main.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.dmitriy.phonetesttask.R
import com.dmitriy.phonetesttask.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()

        lifecycleScope.launch { navigateToHome() }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private suspend fun navigateToHome() {
        delay(2000)

        findNavController().navigate(
            getActionTabsDestination(),
            null,
            navOptions {
                popUpTo(getSplashDestination()) {
                    inclusive = true
                }
            }
        )
    }

    private fun getActionTabsDestination() = R.id.action_splashFragment_to_tabsFragment
    private fun getSplashDestination() = R.id.splashFragment
}
package com.dmitriy.phonetesttask.app.screens.main.tabs.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dmitriy.phonetesttask.*
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.home.adapters.HomeAdapter
import com.dmitriy.phonetesttask.app.base.CoreApplication
import com.dmitriy.phonetesttask.app.di.HomeViewModelFactory
import com.dmitriy.phonetesttask.app.di.component.HomeComponent
import com.dmitriy.phonetesttask.databinding.FragmentHomeBinding
import com.dmitriy.phonetesttask.app.screens.bottomsheet.BottomSheetFragment
import javax.inject.Inject

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    lateinit var homeComponent: HomeComponent

    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory
    lateinit var viewModel: HomeViewModel

    private val adapter = HomeAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        homeComponent = (requireActivity().applicationContext as CoreApplication).appComponent.homeComponent().create()
        homeComponent.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.filterFrameLayout.setOnClickListener { onFilterButtonPressed() }
        initAdapter()
        observeGetItems()
    }

    private fun initAdapter() {
        binding.recyclerView.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun observeGetItems() = viewModel.data.observe(viewLifecycleOwner) {
        adapter.apply {
            items = it
            notifyDataSetChanged()
        }
    }

    private fun onFilterButtonPressed() {
        BottomSheetFragment().show(parentFragmentManager, "FILTER_SHEET_FRAGMENT")
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
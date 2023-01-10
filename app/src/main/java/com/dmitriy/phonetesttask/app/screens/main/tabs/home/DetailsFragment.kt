package com.dmitriy.phonetesttask.app.screens.main.tabs.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.dmitriy.phonetesttask.R
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.details.adapters.DetailsAdapter
import com.dmitriy.phonetesttask.app.base.BaseApplication
import com.dmitriy.phonetesttask.app.di.DetailsViewModelFactory
import com.dmitriy.phonetesttask.app.di.component.DetailsComponent
import com.dmitriy.phonetesttask.databinding.FragmentDetailsBinding
import javax.inject.Inject

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    lateinit var detailsComponent: DetailsComponent

    @Inject
    lateinit var viewModelFactory: DetailsViewModelFactory
    lateinit var viewModel: DetailsViewModel

    private val adapter = DetailsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        detailsComponent = (requireActivity().applicationContext as BaseApplication).appComponent.detailsComponent().create()
        detailsComponent.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[DetailsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.basketButton.setOnClickListener {
            findNavController().navigate(R.id.action_detailsFragment_to_cartFragment)
        }

        initDetailsAdapter()
        observeGetPhoneDetails()
    }

    private fun initDetailsAdapter() {
        binding.recyclerView.adapter = adapter
    }

    private fun observeGetPhoneDetails() = viewModel.data.observe(viewLifecycleOwner) {
        adapter.items = it
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
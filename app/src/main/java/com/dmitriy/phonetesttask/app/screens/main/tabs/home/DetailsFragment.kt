package com.dmitriy.phonetesttask.app.screens.main.tabs.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dmitriy.phonetesttask.R
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.details.adapters.DetailsAdapter
import com.dmitriy.phonetesttask.databinding.FragmentDetailsBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModel: DetailsViewModel
    private val adapter = DetailsAdapter()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
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
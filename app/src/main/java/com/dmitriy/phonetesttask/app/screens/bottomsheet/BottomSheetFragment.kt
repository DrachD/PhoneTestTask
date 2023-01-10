package com.dmitriy.phonetesttask.app.screens.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.dmitriy.phonetesttask.R
import com.dmitriy.phonetesttask.app.adapters.arrayadapters.BrandAdapter
import com.dmitriy.phonetesttask.app.adapters.arrayadapters.PriceAdapter
import com.dmitriy.phonetesttask.app.adapters.arrayadapters.SizeAdapter
import com.dmitriy.phonetesttask.databinding.FragmentFilterSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentFilterSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilterSheetBinding.inflate(inflater, container, false)

        dialog?.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.closeImageButton.setOnClickListener { dismiss() }
        binding.doneFrameLayout.setOnClickListener { dismiss() }

        binding.brandSpinner.adapter = BrandAdapter(requireContext())
        binding.priceSpinner.adapter = PriceAdapter(requireContext())
        binding.sizeSpinner.adapter = SizeAdapter(requireContext())
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun getTheme(): Int {
        return R.style.BottomSheetDialogTheme
    }
}
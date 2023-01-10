package com.dmitriy.phonetesttask.app.screens.main.tabs.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.dmitriy.phonetesttask.R
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.cart.adapters.CartAdapter
import com.dmitriy.phonetesttask.app.base.BaseApplication
import com.dmitriy.phonetesttask.databinding.FragmentCartBinding
import com.dmitriy.phonetesttask.app.controllers.CartController
import com.dmitriy.phonetesttask.app.di.CartViewModelFactory
import com.dmitriy.phonetesttask.app.di.component.CartComponent
import javax.inject.Inject

class CartFragment: Fragment(R.layout.fragment_cart) {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    lateinit var cartComponent: CartComponent

    @Inject
    lateinit var viewModelFactory: CartViewModelFactory
    lateinit var viewModel: CartViewModel

    private lateinit var adapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        cartComponent = (requireActivity().applicationContext as BaseApplication).appComponent.cartComponent().create()
        cartComponent.inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[CartViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener { findNavController().popBackStack() }

        initCartAdapter()
        observeGetBasketList()
    }

    private fun initCartAdapter() {
        adapter = CartAdapter()
        binding.recyclerView.adapter = adapter
    }

    private fun observeGetBasketList() = viewModel.data.observe(viewLifecycleOwner) {
        CartController.resetAllProducts()
        adapter.items = it
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
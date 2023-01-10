package com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate

import android.graphics.Color
import android.graphics.PorterDuff
import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.dmitriy.phonetesttask.app.screens.main.MainActivity
import com.dmitriy.phonetesttask.R
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.base.ListItem
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.details.adapters.ImageAdapter
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.details.adapters.InfoAdapter
import com.dmitriy.phonetesttask.app.adapters.delegateadapter.delegate.details.items.*
import com.dmitriy.phonetesttask.databinding.*
import com.dmitriy.base.core.utils.Downloader
import com.dmitriy.phonetesttask.app.utils.getBaseColor
import com.dmitriy.phonetesttask.app.utils.setBaseColorFilter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import kotlin.math.abs

object DetailsScreenDelegates {

    fun imageItem() = adapterDelegateViewBinding<ImageItem, ListItem, ItemImageBinding>(
        { layoutInflater, parent ->
            ItemImageBinding.inflate(layoutInflater, parent, false)
        }
    ) {

        val adapter = ImageAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.clipToPadding = false
        binding.recyclerView.clipChildren = false
        binding.recyclerView.offscreenPageLimit = 3
        binding.recyclerView.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(40))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.15f
        }

        binding.recyclerView.setPageTransformer(compositePageTransformer)

        bind {
            adapter.items = item.items
        }
    }

    fun infoItem() = adapterDelegateViewBinding<InfoItem, ListItem, ItemInfoBinding>(
        { layoutInflater, parent ->
            ItemInfoBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        val adapter = InfoAdapter()
        binding.recyclerView.adapter = adapter

        bind {
            adapter.items = item.items
        }
    }

    enum class Capacity {
        CAPACITY_128,
        CAPACITY_256
    }

    fun infoCardItem() = adapterDelegateViewBinding<InfoCardItem, ListItem, ItemInfoCardBinding>(
        { layoutInflater, parent ->
            ItemInfoCardBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        val activity = binding.root.context as MainActivity
        var capacity = Capacity.CAPACITY_128
        val resources = binding.root.resources

        bind {
            binding.apply {
                titleTextView.text = item.title
                cameraTextView.text = item.camera
                cpuTextView.text = item.cpu
                ssdTextView.text = item.ssd
                sdTextView.text = item.sd
                firstColorImageButton.setCardBackgroundColor(Color.parseColor(item.colors[0]))
                secondColorImageButton.setCardBackgroundColor(Color.parseColor(item.colors[1]))

                firstColorImageButton.setOnClickListener {
                    firstCheckImageView.visibility = View.VISIBLE
                    secondCheckImageView.visibility = View.GONE
                }

                secondColorImageButton.setOnClickListener {
                    secondCheckImageView.visibility = View.VISIBLE
                    firstCheckImageView.visibility = View.GONE
                }

                bg128FrameLayout.setOnClickListener {
                    if (capacity == Capacity.CAPACITY_256) {
                        bg128FrameLayout.background.setBaseColorFilter(resources.getBaseColor(R.color.orange, null))
                        bg256FrameLayout.background.setBaseColorFilter(resources.getBaseColor(R.color.white, null))
                        bg128TextView.setTextColor(resources.getBaseColor(R.color.white, null))
                        bg256TextView.setTextColor(resources.getBaseColor(R.color.grey_light_8D, null))
                        bg128TextView.text = resources.getString(R.string.gb_128_all_caps_true)
                        bg256TextView.text = resources.getString(R.string.gb_256_all_caps_false)
                        capacity = Capacity.CAPACITY_128
                    }
                }

                bg256FrameLayout.setOnClickListener {
                    if (capacity == Capacity.CAPACITY_128) {
                        bg256FrameLayout.background.setBaseColorFilter(resources.getBaseColor(R.color.orange, null))
                        bg128FrameLayout.background.setBaseColorFilter(resources.getBaseColor(R.color.white, null))
                        bg256TextView.setTextColor(resources.getBaseColor(R.color.white, null))
                        bg128TextView.setTextColor(resources.getBaseColor(R.color.grey_light_8D, null))
                        bg128TextView.text = resources.getString(R.string.gb_128_all_caps_false)
                        bg256TextView.text = resources.getString(R.string.gb_256_all_caps_true)
                        capacity = Capacity.CAPACITY_256
                    }
                }

                addToCardLinearLayout.setOnClickListener {
                    activity.findNavController(R.id.fragmentContainer).navigate(R.id.action_detailsFragment_to_cartFragment)
                }
            }
        }
    }

    fun infoProgressItem() = adapterDelegateViewBinding<InfoProgressCardItem, ListItem, ItemInfoProgressBinding>(
        { layoutInflater, parent ->
            ItemInfoProgressBinding.inflate(layoutInflater, parent, false)
        }
    ) { }

    fun imageCardItem() = adapterDelegateViewBinding<ImageCardItem, ListItem, ItemImageCardBinding>(
        { layoutInflater, parent ->
            ItemImageCardBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        bind {
            Downloader()
                .load(item.image)
                .into(binding.phoneImageView)
        }
    }

    fun imageProgressItem() = adapterDelegateViewBinding<ImageProgressCardItem, ListItem, ItemImageProgressBinding>(
        { layoutInflater, parent ->
            ItemImageProgressBinding.inflate(layoutInflater, parent, false)
        }
    ) { }
}
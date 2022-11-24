package com.dmitriy.phonetesttask.delegateadapter

import android.content.Context
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.dmitriy.phonetesttask.R

class BrandAdapter(
    context: Context
) : ArrayAdapter<OperatedBrand>(context, 0, OperatedBrand.values()) {

    val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View

        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.item_brand, parent, false)
        } else {
            view = convertView
        }

        getItem(position)?.let { brand ->
            setItemForBrand(view, brand)
        }

        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View

        if (position == 0) {
            view = layoutInflater.inflate(R.layout.header_brand, parent, false)
            view.setOnClickListener {
                val root = parent.rootView
                root.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK))
                root.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BACK))
            }
        } else {
            view = layoutInflater.inflate(R.layout.item_brand_dropdown, parent, false)
            getItem(position)?.let{ brand ->
                setItemForBrand(view, brand)
            }
        }

        return view
    }

    override fun getItem(position: Int): OperatedBrand? {
        if (position == 0) {
            return null
        }

        return super.getItem(position - 1)
    }

    override fun getCount(): Int = super.getCount() + 1

    override fun isEnabled(position: Int): Boolean = position != 0

    private fun setItemForBrand(view: View, brand: OperatedBrand) {
        val brandTextView = view.findViewById<TextView>(R.id.titleTextView)

        brandTextView.setText(brand.brandCode)
    }
}

enum class OperatedBrand(val brandCode: Int) {
    SAMSUNG(R.string.samsung),
    IPHONE(R.string.iphone),
    XIAOMI(R.string.xiaomi),
    MOTOROLA(R.string.motorola)
}
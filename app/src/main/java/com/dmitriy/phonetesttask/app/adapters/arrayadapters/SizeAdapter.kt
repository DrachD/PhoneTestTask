package com.dmitriy.phonetesttask.delegateadapter

import android.content.Context
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.dmitriy.phonetesttask.R

class SizeAdapter(
    context: Context
) : ArrayAdapter<OperatedSize>(context, 0, OperatedSize.values()) {

    val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View

        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.item_size, parent, false)
        } else {
            view = convertView
        }

        getItem(position)?.let { size ->
            setItemForBrand(view, size)
        }

        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View

        if (position == 0) {
            view = layoutInflater.inflate(R.layout.header_size, parent, false)
            view.setOnClickListener {
                val root = parent.rootView
                root.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK))
                root.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BACK))
            }
        } else {
            view = layoutInflater.inflate(R.layout.item_size_dropdown, parent, false)
            getItem(position)?.let{ size ->
                setItemForBrand(view, size)
            }
        }

        return view
    }

    override fun getItem(position: Int): OperatedSize? {
        if (position == 0) {
            return null
        }

        return super.getItem(position - 1)
    }

    override fun getCount(): Int = super.getCount() + 1

    override fun isEnabled(position: Int): Boolean = position != 0

    private fun setItemForBrand(view: View, size: OperatedSize) {
        val sizeTextView = view.findViewById<TextView>(R.id.sizeTextView)

        sizeTextView.setText(size.sizeCode)
    }
}

enum class OperatedSize(val sizeCode: Int) {
    SIZE_4_5_TO_5_5(R.string.size_4_5_5_5),
    SIZE_5_5_TO_6_5(R.string.size_5_5_6_5),
    SIZE_6_5_TO_7_5(R.string.size_6_5_7_5)
}
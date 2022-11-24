package com.dmitriy.phonetesttask.delegateadapter

import android.content.Context
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.dmitriy.phonetesttask.R

class PriceAdapter(
    context: Context
) : ArrayAdapter<OperatedPrice>(context, 0, OperatedPrice.values()) {

    val layoutInflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View

        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.item_price, parent, false)
        } else {
            view = convertView
        }

        getItem(position)?.let { price ->
            setItemForBrand(view, price)
        }

        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view: View

        if (position == 0) {
            view = layoutInflater.inflate(R.layout.header_price, parent, false)
            view.setOnClickListener {
                val root = parent.rootView
                root.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK))
                root.dispatchKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BACK))
            }
        } else {
            view = layoutInflater.inflate(R.layout.item_price_dropdown, parent, false)
            getItem(position)?.let{ price ->
                setItemForBrand(view, price)
            }
        }

        return view
    }

    override fun getItem(position: Int): OperatedPrice? {
        if (position == 0) {
            return null
        }

        return super.getItem(position - 1)
    }

    override fun getCount(): Int = super.getCount() + 1

    override fun isEnabled(position: Int): Boolean = position != 0

    private fun setItemForBrand(view: View, price: OperatedPrice) {
        val priceTextView = view.findViewById<TextView>(R.id.priceTextView)

        priceTextView.setText(price.priceCode)
    }
}

enum class OperatedPrice(val priceCode: Int) {
    PRICE_300_500(R.string.price_300_500),
    PRICE_500_700(R.string.price_500_700),
    PRICE_700_900(R.string.price_700_900),
    PRICE_0_10000(R.string.price_0_10000)
}
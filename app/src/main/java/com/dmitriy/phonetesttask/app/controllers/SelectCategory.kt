package com.dmitriy.phonetesttask.app.controllers

import com.dmitriy.phonetesttask.R

object SelectCategory {

    data class SelectCategoryData(
        val positionSelected: Int,
        val category: Int,
        val icon: Int
    )

    const val backgroundColorSelected = R.color.orange
    const val backgroundColorUnselected = R.color.white

    const val colorTintSelected = R.color.white
    const val colorTintUnselected = R.color.grey

    const val textColorSelected = R.color.orange
    const val textColorUnselected = R.color.black

    var positionSelected: Int = 0

    val list = listOf(
        SelectCategoryData(0, R.string.phones, R.drawable.ic_phones),
        SelectCategoryData(1, R.string.computer, R.drawable.ic_computer),
        SelectCategoryData(2, R.string.health, R.drawable.ic_health),
        SelectCategoryData(3, R.string.books, R.drawable.ic_books),
        SelectCategoryData(4, R.string.something, R.drawable.ic_something)
    )
}
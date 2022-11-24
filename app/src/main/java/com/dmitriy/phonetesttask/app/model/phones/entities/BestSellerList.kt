package com.dmitriy.phonetesttask.app.model.phones.entities

import com.dmitriy.phonetesttask.R

data class BestSellerList(
    val list: List<BestSeller> = listOf(
        BestSeller(
            1,
            R.string.samsung_galaxy_s20_ultra,
            R.string.price_1047,
            R.string.price_1500,
            R.mipmap.samsung_galaxy_s20_ultra_1_1
        ),
        BestSeller(
            2,
            R.string.xiaomi_mi_10_pro,
            R.string.price_300,
            R.string.price_400,
            R.mipmap.samsung_galaxy_s20_ultra_1_1_1
        ),
        BestSeller(
            3,
            R.string.samsung_note_20_ultra,
            R.string.price_1047,
            R.string.price_1500,
            R.mipmap.samsung_galaxy_s20_ultra_1_1_2
        ),
        BestSeller(
            4,
            R.string.motorola_one_edge,
            R.string.price_300,
            R.string.price_400,
            R.mipmap.samsung_galaxy_s20_ultra_1_1_3
        )
    )
)
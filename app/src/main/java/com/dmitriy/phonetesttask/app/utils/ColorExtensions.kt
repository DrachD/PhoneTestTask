package com.dmitriy.phonetesttask.app.utils

import android.content.res.Resources
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.Nullable

@ColorInt
fun Resources.getBaseColor(@ColorRes id: Int, theme: Resources.Theme?): Int {
    return if (VERSION.SDK_INT >= VERSION_CODES.M) {
        getColor(id, theme)
    } else {
        getColor(id)
    }
}
package com.dmitriy.base.core.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import kotlinx.coroutines.*
import java.net.URL

class Downloader {

    private lateinit var url: String
    private lateinit var itemView: View

    init {
        CoroutineScope(Dispatchers.Main + Job()).launch {
            val bitmap = createBitmapFromUrl(url)
            (itemView as AppCompatImageView).setImageBitmap(bitmap)
        }
    }

    fun load(url: String): Downloader {

        this.url = url

        return this
    }

    fun into(itemView: View): Downloader {

        this.itemView = itemView

        return this
    }

    private suspend fun createBitmapFromUrl(address: String): Bitmap? = withContext(Dispatchers.IO) {

        try {
            val url = URL(address)
            val inputStream = url.openStream()
            BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
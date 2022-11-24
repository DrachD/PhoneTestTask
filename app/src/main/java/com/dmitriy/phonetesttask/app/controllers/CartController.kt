package com.dmitriy.phonetesttask.app.controllers

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

object CartController {

    private val _getTotalPriceEvent = MutableSharedFlow<Int>()
    val getTotalPriceEvent: MutableSharedFlow<Int> = _getTotalPriceEvent

    private val _getCountItemsEvent = MutableSharedFlow<Int>()
    val getCountItemsEvent: MutableSharedFlow<Int> = _getCountItemsEvent

    private val _getDeliveryIsFreeEvent = MutableSharedFlow<Boolean>()
    val getDeliveryIsFreeEvent: MutableSharedFlow<Boolean> = _getDeliveryIsFreeEvent

    private val _getDeliveryPrice: MutableSharedFlow<Int> = MutableSharedFlow<Int>()
    val getDeliveryPrice: MutableSharedFlow<Int> = _getDeliveryPrice

    var totalPrice: Int = 0
        private set

    var countItems: Int = 0
        private set

    var deliveryIsFree: Boolean = true
        private set

    var deliveryPrice: Int = 0
        private set

    fun addProduct(price: Int) = CoroutineScope(Dispatchers.IO).launch {

        addItem()

        totalPrice += price
        _getTotalPriceEvent.emit(totalPrice)
    }

    fun removeProduct(price: Int) = CoroutineScope(Dispatchers.IO).launch {

        if (countItems <= 0) return@launch

        removeItem()

        totalPrice -= price
        _getTotalPriceEvent.emit(totalPrice)
    }

    fun resetProducts(price: Int, countItems: Int) = CoroutineScope(Dispatchers.IO).launch {

        CartController.countItems -= countItems

        totalPrice -= price * countItems
        _getTotalPriceEvent.emit(totalPrice)
    }

    fun resetAllProducts() = CoroutineScope(Dispatchers.IO).launch {
        resetItems()

        totalPrice = 0
        _getTotalPriceEvent.emit(0)
    }

    private fun resetItems() = CoroutineScope(Dispatchers.IO).launch {
        countItems = 0
        _getCountItemsEvent.emit(countItems)
    }

    private fun addItem() = CoroutineScope(Dispatchers.IO).launch {
        countItems += 1
        _getCountItemsEvent.emit(countItems)
    }

    private fun removeItem() = CoroutineScope(Dispatchers.IO).launch {
        countItems -= 1
        _getCountItemsEvent.emit(countItems)
    }

    private fun setDelivery(isFree: Boolean, price: Int) = CoroutineScope(Dispatchers.IO).launch {

        deliveryPrice = if (isFree) 0 else price
        deliveryIsFree = isFree

        _getDeliveryIsFreeEvent.emit(deliveryIsFree)
        _getDeliveryPrice.emit(deliveryPrice)
    }
}
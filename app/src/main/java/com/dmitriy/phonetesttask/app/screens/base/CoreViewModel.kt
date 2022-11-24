package com.dmitriy.phonetesttask.app.screens.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class CoreViewModel : ViewModel() {

    protected val _showProgressEvent = MutableLiveData<Boolean>()
    val showProgressEvent: MutableLiveData<Boolean> = _showProgressEvent

    protected val _showMessageEvent = MutableLiveData<Message>()
    val showMessageEvent: MutableLiveData<Message> = _showMessageEvent

    protected fun showProgress() {
        _showProgressEvent.value = true
    }

    protected fun hideProgress() {
        _showProgressEvent.value = false
    }

    protected fun showMessage(message: String?, code: Int?) {
        _showMessageEvent.value = Message(
            message = message,
            code = code
        )
    }

    data class Message(
        val message: String?,
        val code: Int?
    )
}
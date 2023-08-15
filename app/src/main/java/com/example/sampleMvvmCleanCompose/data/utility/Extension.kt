package com.example.sampleMvvmCleanCompose.data.utility

import java.net.SocketTimeoutException
import java.net.UnknownHostException


fun Exception.getMessage():String{

    return if (this is UnknownHostException) {
        "No internet connection"
    } else if (this is SocketTimeoutException) {
        "Time out please try again"
    } else {
        localizedMessage
    }
}
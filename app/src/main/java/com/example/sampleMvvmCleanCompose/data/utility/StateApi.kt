package com.example.sampleMvvmCleanCompose.data.utility

public sealed class StateApi<T>(val data: T? = null, open val message: String? = null) {

    class Loading<T>():StateApi<T>()

    class Success<T>(data: T) : StateApi<T>(data)

    class Error<T>(message: String) : StateApi<T>()
}
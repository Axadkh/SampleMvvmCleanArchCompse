package com.example.sampleMvvmCleanCompose.data.utility

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

class LenientTypeAdapterFactory : TypeAdapterFactory {
    override fun <T : Any?> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T>? {
        val delegate = gson.getDelegateAdapter(this, type)
        return LenientTypeAdapter(delegate)
    }
}

class LenientTypeAdapter<T>(private val delegate: TypeAdapter<T>) : TypeAdapter<T>() {
    override fun write(out: JsonWriter?, value: T) {
        delegate.write(out, value)
    }

    override fun read(`in`: JsonReader): T? {
        return try {
            delegate.read(`in`)
        } catch (e: Exception) {
            `in`.skipValue() // Skip the invalid value and continue parsing
            null
        }
    }
}




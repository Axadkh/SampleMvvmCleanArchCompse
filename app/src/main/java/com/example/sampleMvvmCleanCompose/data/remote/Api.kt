package com.example.sampleMvvmCleanCompose.data.remote.dto

import com.example.sampleMvvmCleanCompose.data.remote.dto.product.ProductDetailsDto
import com.example.sampleMvvmCleanCompose.data.remote.dto.product.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("/products/{id}")
    suspend fun getProduct(@Path("id") id:Int): ProductDetailsDto

    @GET("/products")
    suspend fun getProducts():List<ProductDto>
}
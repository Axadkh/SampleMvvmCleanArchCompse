package com.example.sampleMvvmCleanCompose.data.repository

import com.example.sampleMvvmCleanCompose.data.remote.dto.product.ProductDetailsDto
import com.example.sampleMvvmCleanCompose.data.remote.dto.product.ProductDto

interface ProductRepository {

    suspend fun getProduct(id:Int):ProductDetailsDto

    suspend fun getProducts():List<ProductDto>
}
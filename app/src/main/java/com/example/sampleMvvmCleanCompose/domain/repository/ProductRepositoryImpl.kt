package com.example.sampleMvvmCleanCompose.domain.repository

import com.example.sampleMvvmCleanCompose.data.remote.dto.Api
import com.example.sampleMvvmCleanCompose.data.remote.dto.product.ProductDetailsDto
import com.example.sampleMvvmCleanCompose.data.remote.dto.product.ProductDto
import com.example.sampleMvvmCleanCompose.data.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val api: Api):ProductRepository{


    override suspend fun getProduct(id: Int): ProductDetailsDto {
        return  api.getProduct(id)
    }

    override suspend fun getProducts(): List<ProductDto> {
        return  api.getProducts()
    }


}
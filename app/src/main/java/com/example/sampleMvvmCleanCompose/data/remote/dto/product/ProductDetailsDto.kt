package com.example.sampleMvvmCleanCompose.data.remote.dto.product

import com.example.sampleMvvmCleanCompose.domain.model.ProductDetail

data class ProductDetailsDto(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)

fun ProductDetailsDto.toProductDetail(): ProductDetail {
    return  ProductDetail(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        rating = rating,
        title = title
    )
}
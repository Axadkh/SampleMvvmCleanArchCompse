package com.example.sampleMvvmCleanCompose.data.remote.dto.product

import com.example.sampleMvvmCleanCompose.domain.model.Product

data class ProductDto(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String

)

fun ProductDto.toProduct():Product{
    return  Product(
        id = id,
        image = image,
        price = price,
        rating = rating,
        title = title
    )
}
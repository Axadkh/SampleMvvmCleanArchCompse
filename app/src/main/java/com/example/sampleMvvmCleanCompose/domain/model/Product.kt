package com.example.sampleMvvmCleanCompose.domain.model

import com.example.sampleMvvmCleanCompose.data.remote.dto.product.Rating

data class Product(val id: Int,
                   val image: String,
                   val price: Double,
                   val rating: Rating,
                   val title: String)
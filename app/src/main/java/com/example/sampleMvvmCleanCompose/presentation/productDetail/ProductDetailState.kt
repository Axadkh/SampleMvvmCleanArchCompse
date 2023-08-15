package com.example.sampleMvvmCleanCompose.presentation.productDetail

import com.example.sampleMvvmCleanCompose.domain.model.ProductDetail

data class ProductDetailState(
    val isLoading:Boolean = false,
    val productDetail :ProductDetail?=null,
    val error: String =""
)
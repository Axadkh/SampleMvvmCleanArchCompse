package com.example.sampleMvvmCleanCompose.domain.use_cases.getProductList_usecase

import com.example.sampleMvvmCleanCompose.domain.model.Product

data class ProductListState(
    val isLoading:Boolean =false,
    val products: List<Product> = emptyList(),
    val error:String =""
)
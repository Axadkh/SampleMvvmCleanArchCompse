package com.example.sampleMvvmCleanCompose.domain.use_cases.doctorList

import com.example.sampleMvvmCleanCompose.data.utility.StateApi
import com.example.sampleMvvmCleanCompose.data.remote.dto.product.toProductDetail
import com.example.sampleMvvmCleanCompose.data.repository.ProductRepository
import com.example.sampleMvvmCleanCompose.data.utility.getMessage
import com.example.sampleMvvmCleanCompose.domain.model.ProductDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductUseCase @Inject constructor(val repository: ProductRepository) {
    operator fun invoke(id:Int): Flow<StateApi<ProductDetail>> = flow {
        try {
            emit(StateApi.Loading())
            val productDetail = repository.getProduct(id).toProductDetail()
            emit(StateApi.Success(productDetail))
        } catch (ex: Exception) {
            emit(StateApi.Error(ex.getMessage()))
        }
    }
}
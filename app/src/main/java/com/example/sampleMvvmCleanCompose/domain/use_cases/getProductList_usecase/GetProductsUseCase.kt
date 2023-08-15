package com.example.sampleMvvmCleanCompose.domain.use_cases.getProductList_usecase

import com.example.sampleMvvmCleanCompose.data.utility.StateApi
import com.example.sampleMvvmCleanCompose.data.remote.dto.product.toProduct
import com.example.sampleMvvmCleanCompose.data.repository.ProductRepository
import com.example.sampleMvvmCleanCompose.data.utility.getMessage
import com.example.sampleMvvmCleanCompose.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private  val repository: ProductRepository) {

    operator fun invoke(): Flow<StateApi<List<Product>>> = flow {
        try {
            emit(StateApi.Loading())
            val products = repository.getProducts().map { it.toProduct() }
            emit(StateApi.Success(products))

        }catch (ex:Exception){
            ex.printStackTrace()
            emit(StateApi.Error(ex.getMessage()))
        }
    }
}
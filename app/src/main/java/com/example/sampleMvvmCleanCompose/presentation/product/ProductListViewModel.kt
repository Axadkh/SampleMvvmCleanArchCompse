package com.example.sampleMvvmCleanCompose.presentation.product

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleMvvmCleanCompose.data.utility.StateApi
import com.example.sampleMvvmCleanCompose.domain.use_cases.getProductList_usecase.GetProductsUseCase
import com.example.sampleMvvmCleanCompose.domain.use_cases.getProductList_usecase.ProductListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val getProductsUseCase: GetProductsUseCase) :
    ViewModel() {

    private val _state = mutableStateOf(ProductListState())
    val state: State<ProductListState> = _state

    init {
        getProducts()
    }

    private fun getProducts() {
        getProductsUseCase().onEach { result ->
            when (result) {
                is StateApi.Loading -> {
                    _state.value = ProductListState(isLoading = true)
                }

                is StateApi.Success -> {
                    _state.value = ProductListState(products = result.data ?: emptyList())
                }

                is StateApi.Error -> {
                    _state.value = ProductListState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }


}
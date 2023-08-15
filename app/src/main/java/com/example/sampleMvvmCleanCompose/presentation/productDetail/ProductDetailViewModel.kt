package com.example.sampleMvvmCleanCompose.presentation.productDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleMvvmCleanCompose.common.utls.etension.PARAM
import com.example.sampleMvvmCleanCompose.data.utility.StateApi
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

import com.example.sampleMvvmCleanCompose.domain.use_cases.doctorList.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductsUseCase: GetProductUseCase,
    savedStateHandle: SavedStateHandle
    )
    :ViewModel(){

    init {
        savedStateHandle.get<Int>(PARAM.PARAM_PRODUCT_ID)?.let {
            getProductDetail(it) }
    }

    private val _state = mutableStateOf<ProductDetailState>(ProductDetailState())
    val state: State<ProductDetailState> = _state

    fun getProductDetail(id:Int){
            getProductsUseCase(id).onEach { result ->
                when (result) {
                    is StateApi.Loading -> {
                        _state.value = ProductDetailState(isLoading = true)
                    }

                    is StateApi.Success -> {
                        _state.value = ProductDetailState(productDetail = result.data)
                    }

                    is StateApi.Error -> {
                        _state.value = ProductDetailState(error =result.message?:"")
                    }
                }
            }.launchIn(viewModelScope)
        }


}
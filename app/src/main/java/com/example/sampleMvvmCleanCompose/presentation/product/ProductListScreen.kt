package com.example.sampleMvvmCleanCompose.presentation.product
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.sampleMvvmCleanCompose.presentation.navgation.Screen
import com.example.sampleMvvmCleanCompose.presentation.product.components.ProductListItem
import com.example.sampleMvvmCleanCompose.presentation.ui.ShowProgress

@Composable
fun  ProductListScreen(navController:NavController,
                       viewModel:ProductListViewModel = hiltViewModel()) {

    val state = viewModel.state.value
    Box (modifier = Modifier.fillMaxWidth()){
        
        LazyColumn(modifier = Modifier.fillMaxSize()){
          items(items = state.products){product->
              ProductListItem(product = product){
                  navController
                      .navigate(Screen.ProductDetailsScreen.route+"/${product.id}")
              }
          }
        }

        if(state.error.isNotBlank()){
            Text(text = state.error,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Red,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center))
        }

        if(state.isLoading){
            ShowProgress()
        }
    }

}
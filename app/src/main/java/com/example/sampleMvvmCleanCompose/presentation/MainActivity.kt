package com.example.sampleMvvmCleanCompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sampleMvvmCleanCompose.presentation.navgation.Screen
import com.example.sampleMvvmCleanCompose.presentation.product.ProductListScreen
import com.example.sampleMvvmCleanCompose.presentation.theme.AppYTTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppYTTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.ProductListScreen.route ){

                        composable(route = Screen.ProductListScreen.route){
                            ProductListScreen(navController)

                        }

                        composable(route = Screen.ProductDetailsScreen.route+"/id"){
                           //// ProductListScreen(navController)
                        }
                    }


                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppYTTheme {

    }
}
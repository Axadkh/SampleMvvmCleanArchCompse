package com.example.sampleMvvmCleanCompose.presentation.navgation

sealed class Screen(val route:String) {
    object ProductListScreen: Screen("product_list_screen")
    object ProductDetailsScreen: Screen("product_details_screen")
}
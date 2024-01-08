package com.example.cripper.presentation.presentation.screens

 sealed class Destination(val route:String) {
    object CoinListScreen: Destination("coin_list_screen")
     object CoinDetailScreen: Destination("coin_detail_screen")
}
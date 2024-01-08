package com.example.cripper.presentation.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cripper.presentation.presentation.theme.CripperTheme
import com.example.cripper.presentation.presentation.screens.CoinDetailsScreen
import com.example.cripper.presentation.presentation.screens.CoinListScreen
import com.example.cripper.presentation.presentation.screens.Destination
import com.example.cripper.presentation.presentation.viewModels.CoinListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CripperTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  val navController = rememberNavController()
                    val listViewModel:CoinListViewModel by viewModels()



                    NavHost(navController = navController ,
                        startDestination = Destination.CoinListScreen.route ){

                        composable(route=Destination.CoinListScreen.route){
                            CoinListScreen(navController = navController,viewModel = listViewModel)
                        }

                        composable(route= Destination.CoinDetailScreen.route + "/{coinId}"){
                            CoinDetailsScreen()
                        }
                    }
                }
            }
        }
    }
}


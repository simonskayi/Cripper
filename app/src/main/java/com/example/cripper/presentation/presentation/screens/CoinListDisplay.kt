package com.example.cripper.presentation.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cripper.presentation.presentation.components.CoinListItem
import com.example.cripper.presentation.presentation.viewModels.CoinListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinListScreen(navController: NavController, viewModel:CoinListViewModel) {
    val state = viewModel.state.value

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar ={
            TopAppBar(title = { Text(text = "Cripper", fontFamily = FontFamily.Cursive) },
                colors = TopAppBarDefaults
                    .smallTopAppBarColors(containerColor = MaterialTheme
                        .colorScheme.surfaceColorAtElevation(4.dp)))
        }
    ) {
    Box(modifier= Modifier
        .fillMaxSize()
        .padding(it)) {
       LazyColumn(modifier = Modifier.fillMaxSize(),
           contentPadding = PaddingValues(5.dp),
           verticalArrangement = Arrangement.spacedBy(15.dp)){

           items(state.coins){coin->
               CoinListItem(coin = coin) {coins->
                   Log.d("MyActivity", coins.id)
                   navController.navigate(Destination.CoinDetailScreen.route + "/${coins.id}"
                   )
               }
           }
       }
        if(state.error.isNotBlank()){
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                fontSize= 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(22.dp)
                    .align(
                        Alignment.Center
                    )
            )
        }
        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }


    }

}}
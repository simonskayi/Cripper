package com.example.cripper.presentation.presentation.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cripper.domain.usecase.GetCoinUseCase
import com.example.cripper.utils.CoinDetailsState
import com.example.cripper.utils.Constants.COIN_ID
import com.example.cripper.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

    @HiltViewModel
    class CoinDetailsViewModel @Inject constructor(
        private val  getCoinUseCase: GetCoinUseCase,
       val savedStateHandle: SavedStateHandle
    ): ViewModel() {

        private val _state = mutableStateOf(CoinDetailsState())
        val state: State<CoinDetailsState> = _state

        init {
            savedStateHandle.get<String>(COIN_ID)?.let {
                getCoin(coinId = it)
            }
        }

        private fun getCoin(coinId:String){
            getCoinUseCase(coinID = coinId).onEach {
                when(it){
                    is Resource.Success -> {
                        _state.value = CoinDetailsState(coins = it.data)
                    }
                    is Resource.Error -> {
                        _state.value = CoinDetailsState(error= it.message?: "An unexpected Error")
                    }
                    is Resource.Loading -> {
                        _state.value = CoinDetailsState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

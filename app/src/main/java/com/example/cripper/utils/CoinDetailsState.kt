package com.example.cripper.utils

import com.example.cripper.domain.model.Coin
import com.example.cripper.domain.model.CoinDetail

data class CoinDetailsState (
        val isLoading:Boolean = false,
        val coins: CoinDetail? = null,
        val error: String = ""

)

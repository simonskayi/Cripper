package com.example.cripper.domain.repository

import com.example.cripper.data.dto.CoinDetailsDto
import com.example.cripper.data.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins():List<CoinDto>

    suspend fun getCoinsByID(coinID:String): CoinDetailsDto
}
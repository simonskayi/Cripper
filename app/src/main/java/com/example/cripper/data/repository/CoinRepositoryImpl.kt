package com.example.cripper.data.repository

import com.example.cripper.data.CoinPaprikaApi
import com.example.cripper.data.dto.CoinDetailsDto
import com.example.cripper.data.dto.CoinDto
import com.example.cripper.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(private val api: CoinPaprikaApi):CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinsByID(coinID: String): CoinDetailsDto {
        return api.getCoinById(coinId = coinID)
    }
}
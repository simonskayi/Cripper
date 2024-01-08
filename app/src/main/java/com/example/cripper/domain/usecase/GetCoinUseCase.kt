package com.example.cripper.domain.usecase

import com.example.cripper.data.dto.toCoin
import com.example.cripper.data.dto.toCoinDetails
import com.example.cripper.domain.model.Coin
import com.example.cripper.domain.model.CoinDetail
import com.example.cripper.domain.repository.CoinRepository
import com.example.cripper.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


    class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {

        operator fun invoke(coinID:String): Flow<Resource<CoinDetail>> = flow{
            try{
                emit(Resource.Loading())
                val coin = repository.getCoinsByID(coinID).toCoinDetails()
                emit(Resource.Success(coin))
            }
            catch (e: HttpException){
                emit(Resource.Error(e.localizedMessage ?: "An Unknown Error Occurred"))
            }
            catch (e: IOException){
                emit(Resource.Error("Check Your Internet Connections"))
            }
        }

    }

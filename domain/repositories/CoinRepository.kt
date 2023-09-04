package com.yilmazvolkan.crytocurrencyapp.domain.repositories

import com.yilmazvolkan.crytocurrencyapp.data.remote.dto.CoinDetailDto
import com.yilmazvolkan.crytocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

}

package com.yilmazvolkan.crytocurrencyapp.data.repositories

import com.yilmazvolkan.crytocurrencyapp.data.remote.CoinPaprikaApi
import com.yilmazvolkan.crytocurrencyapp.data.remote.dto.CoinDetailDto
import com.yilmazvolkan.crytocurrencyapp.data.remote.dto.CoinDto
import com.yilmazvolkan.crytocurrencyapp.domain.repositories.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}
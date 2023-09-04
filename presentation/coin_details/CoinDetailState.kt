package com.yilmazvolkan.crytocurrencyapp.presentation.coin_details

import com.yilmazvolkan.crytocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
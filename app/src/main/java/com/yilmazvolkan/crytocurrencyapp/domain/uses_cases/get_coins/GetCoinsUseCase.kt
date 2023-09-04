package com.yilmazvolkan.crytocurrencyapp.domain.uses_cases.get_coins

import com.yilmazvolkan.crytocurrencyapp.common.Resource
import com.yilmazvolkan.crytocurrencyapp.data.remote.dto.toCoin
import com.yilmazvolkan.crytocurrencyapp.domain.model.Coin
import com.yilmazvolkan.crytocurrencyapp.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "Unexpected error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("No Internet connection!"))
        }
    }
}

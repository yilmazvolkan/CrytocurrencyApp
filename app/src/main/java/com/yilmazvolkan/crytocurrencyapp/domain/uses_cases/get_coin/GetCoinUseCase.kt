package com.yilmazvolkan.crytocurrencyapp.domain.uses_cases.get_coin

import com.yilmazvolkan.crytocurrencyapp.common.Resource
import com.yilmazvolkan.crytocurrencyapp.data.remote.dto.toCoinDetail
import com.yilmazvolkan.crytocurrencyapp.domain.model.CoinDetail
import com.yilmazvolkan.crytocurrencyapp.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "Unexpected error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("No Internet connection!"))
        }
    }
}

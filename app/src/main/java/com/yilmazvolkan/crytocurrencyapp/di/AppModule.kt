package com.yilmazvolkan.crytocurrencyapp.di

import com.yilmazvolkan.crytocurrencyapp.common.Constants
import com.yilmazvolkan.crytocurrencyapp.data.remote.CoinPaprikaApi
import com.yilmazvolkan.crytocurrencyapp.data.repositories.CoinRepositoryImpl
import com.yilmazvolkan.crytocurrencyapp.domain.repositories.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaAPI(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}

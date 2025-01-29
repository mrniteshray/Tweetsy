package xcom.niteshray.apps.tweetsy.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xcom.niteshray.apps.tweetsy.api.TweetsApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModules {

    @Singleton
    @Provides
    fun getRetrofit() : Retrofit{
        return  Retrofit.Builder()
            .baseUrl("https://api.jsonbin.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getTweetApi(retrofit: Retrofit) : TweetsApi {
        return retrofit.create(TweetsApi::class.java)
    }
}
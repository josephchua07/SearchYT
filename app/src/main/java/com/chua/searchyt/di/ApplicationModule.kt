package com.chua.searchyt.di

import com.chua.searchyt.repository.YoutubeRepository
import com.chua.searchyt.repository.YoutubeRepositoryImpl
import com.chua.searchyt.service.YoutubeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.googleapis.com/youtube/v3/")
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideYoutubeService(retrofit: Retrofit): YoutubeService =
        retrofit.create(YoutubeService::class.java)

    @Provides
    fun provideYoutubeRepository(youtubeService: YoutubeService): YoutubeRepository =
        YoutubeRepositoryImpl(youtubeService)

}
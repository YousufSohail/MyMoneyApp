package com.yousufsohail.android.home.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.yousufsohail.android.App
import com.yousufsohail.android.home.cache.NewsRepositoryImpl
import com.yousufsohail.android.home.cache.StocksRepositoryImpl
import com.yousufsohail.android.home.cache.util.StockParser
import com.yousufsohail.android.home.repository.NewsRepository
import com.yousufsohail.android.home.repository.StocksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HomeModule {
    @Provides
    fun provideContext(application: App): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun provideNewsRepository(@ApplicationContext context: Context, gson: Gson) =
        NewsRepositoryImpl(context, gson) as NewsRepository

    @Singleton
    @Provides
    fun provideStocksRepository(@ApplicationContext context: Context, stockParser: StockParser) =
        StocksRepositoryImpl(context, stockParser) as StocksRepository
}

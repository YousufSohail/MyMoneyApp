package com.yousufsohail.android.home.di

import com.yousufsohail.android.home.api.ApiService
import com.yousufsohail.android.home.api.DefaultApiService
import com.yousufsohail.android.home.domain.usecase.DefaultGetNewsUseCase
import com.yousufsohail.android.home.domain.usecase.DefaultGetStocksUseCase
import com.yousufsohail.android.home.domain.usecase.DefaultGetTrendingNewsUseCase
import com.yousufsohail.android.home.domain.usecase.GetNewsUseCase
import com.yousufsohail.android.home.domain.usecase.GetStocksUseCase
import com.yousufsohail.android.home.domain.usecase.GetTrendingNewsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class HomeModuleBindings {

    @Binds
    abstract fun bindService(instance: DefaultApiService): ApiService

    @Binds
    abstract fun bindGetStocksUseCase(instance: DefaultGetStocksUseCase): GetStocksUseCase

    @Binds
    abstract fun bindGetTrendingNewsUseCase(instance: DefaultGetTrendingNewsUseCase): GetTrendingNewsUseCase

    @Binds
    abstract fun bindGetNewsUseCase(instance: DefaultGetNewsUseCase): GetNewsUseCase
}

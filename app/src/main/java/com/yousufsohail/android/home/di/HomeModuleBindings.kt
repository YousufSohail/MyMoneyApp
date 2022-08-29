package com.yousufsohail.android.home.di

import com.yousufsohail.android.home.api.DefaultApiService
import com.yousufsohail.android.home.api.ApiService
import com.yousufsohail.android.home.domain.DefaultUseCase
import com.yousufsohail.android.home.domain.UseCase
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
    abstract fun bindUseCase(instance: DefaultUseCase): UseCase
}

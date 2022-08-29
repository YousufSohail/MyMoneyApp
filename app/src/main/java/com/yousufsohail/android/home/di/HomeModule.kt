package com.yousufsohail.android.home.di

import com.yousufsohail.android.home.api.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class HomeModule {
    @Provides
    fun providePoiApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)
}

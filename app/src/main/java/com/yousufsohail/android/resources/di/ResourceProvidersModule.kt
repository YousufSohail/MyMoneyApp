package com.yousufsohail.android.resources.di

import com.yousufsohail.android.resources.DefaultStringResourceProvider
import com.yousufsohail.android.resources.StringResourceProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Dependencies that help in managing Android based resources or other common logic providers.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class ResourceProvidersModule {
    @Binds
    abstract fun bindStringResourceProvider(instance: DefaultStringResourceProvider): StringResourceProvider
}

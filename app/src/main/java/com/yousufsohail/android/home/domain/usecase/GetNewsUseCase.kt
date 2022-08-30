package com.yousufsohail.android.home.domain.usecase

import com.yousufsohail.android.common.BaseUseCase
import com.yousufsohail.android.home.domain.model.NewsResults
import com.yousufsohail.android.home.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetNewsUseCase : BaseUseCase<Pair<Double, Double>, Flow<NewsResults>>

class DefaultGetNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) : GetNewsUseCase {
    override suspend fun execute(input: Pair<Double, Double>): Flow<NewsResults> {
        return flow {
            newsRepository.getNews()
        }
    }
}

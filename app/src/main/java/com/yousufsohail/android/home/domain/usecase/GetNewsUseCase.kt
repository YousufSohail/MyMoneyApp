package com.yousufsohail.android.home.domain.usecase

import com.yousufsohail.android.common.BaseUseCase
import com.yousufsohail.android.home.domain.DataState
import com.yousufsohail.android.home.domain.model.NewsResults
import com.yousufsohail.android.home.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface GetNewsUseCase : BaseUseCase<Boolean, Flow<DataState<List<NewsResults.News>>>>

class DefaultGetNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) : GetNewsUseCase {

    override suspend fun execute(input: Boolean): Flow<DataState<List<NewsResults.News>>> = flow {
        try {
            emit(DataState.loading())
            emit(DataState.success(newsRepository.getNews()))
        } catch (e: Exception) {
            emit(DataState.error(e.message ?: "Unknown error"))
        }
    }
}

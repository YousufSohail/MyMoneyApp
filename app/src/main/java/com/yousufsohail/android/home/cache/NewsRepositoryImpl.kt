package com.yousufsohail.android.home.cache

import android.content.Context
import com.google.gson.Gson
import com.yousufsohail.android.home.cache.util.NewsParser
import com.yousufsohail.android.home.domain.model.NewsResults
import com.yousufsohail.android.home.repository.NewsRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson
) : NewsRepository {

    override fun getTrendingNews(): List<NewsResults.News> {
        TODO("Not yet implemented")
    }

    override fun getNews(): List<NewsResults.News> {
        //TODO: Improvement: first save in to the local storage then get
        return NewsParser.parse(context, gson)
    }
}

package com.yousufsohail.android.home.repository

import com.yousufsohail.android.home.domain.model.NewsResults

interface NewsRepository {
    fun getTrendingNews(): List<NewsResults.News>
    fun getNews(): List<NewsResults.News>
}

package com.yousufsohail.android.home.repository

import com.yousufsohail.android.home.domain.model.NewsResults

interface NewsRepository {
    fun getNews(): List<NewsResults.News>
}

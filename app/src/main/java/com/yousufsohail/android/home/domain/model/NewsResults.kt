package com.yousufsohail.android.home.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class NewsResults(
    val articles: List<News>,
) : Parcelable {
    @Parcelize
    data class News(
        val id: String = UUID.randomUUID().toString(),
        var author: String,
        var title: String,
        var description: String,
        var urlToImage: String,
        var publishedAt: String,
    ) : Parcelable
}



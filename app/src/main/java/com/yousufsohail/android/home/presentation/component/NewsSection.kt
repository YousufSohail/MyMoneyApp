package com.yousufsohail.android.home.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yousufsohail.android.home.domain.model.NewsResults

@Composable
fun NewsSection(trendingNews: List<NewsResults.News>, news: List<NewsResults.News>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            trendingNews.forEach { news ->
                Box(modifier = Modifier.size(100.dp)) {
                    Text(text = news.title)
                }
            }
        }
        LazyColumn {
            items(news) { news ->
                Box(modifier = Modifier.size(100.dp)) {
                    Text(text = news.title)
                }
            }
        }
    }

}

package com.yousufsohail.android.home.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.yousufsohail.android.R
import com.yousufsohail.android.home.domain.model.NewsResults

@Preview
@Composable
fun PreviewNewsSection() {

    val news = NewsResults.News(
        "123",
        "Issy Ronald, CNN",
        "'God needs to come and explain it': How the football world reacted to Real Madrid's extraordinary Champions League semifinal victory",
        "\"We have a score to settle,\" Liverpool star Mo Salah tweeted after Real Madrid staged an extraordinary late comeback against Manchester City to set up a clash with the Reds in the Champions League final on May 28.",
        "https://cdn.cnn.com/cnnnext/dam/assets/220504173124-11-champions-league-semifinal-real-madrid-manchester-city-super-tease.jpg",
        "2022-05-05T10:06:14Z"
    )

    NewsSection(listOf(news, news, news, news), listOf(news, news, news, news, news, news, news, news))

}

@Composable
fun NewsSection(trendingNews: List<NewsResults.News>, news: List<NewsResults.News>) {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = stringResource(R.string.top_news), style = MaterialTheme.typography.h5)
        LazyRow(
            modifier = Modifier
                .padding(bottom = 16.dp)
        ) {
            items(trendingNews) { news ->
                TopNewsItemView(news)
            }
        }

        Text(text = stringResource(R.string.full_coverage), style = MaterialTheme.typography.h5)
        LazyColumn {
            items(news) { news ->
                NewsItemView(news)
            }
        }
    }
}

@Composable
fun TopNewsItemView(news: NewsResults.News) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier.padding(end = 8.dp)
    ) {
        Column(
            modifier = Modifier
                .size(
                    width = 200.dp,
                    height = 260.dp
                )
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(news.urlToImage)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(R.string.cd_news_item),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(200.dp)
            )
            Text(
                text = news.title,
                maxLines = 2,
                softWrap = true,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
    }
}

@Composable
fun NewsItemView(news: NewsResults.News) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(news.urlToImage)
                    .crossfade(true)
                    .build(),
                contentDescription = stringResource(R.string.cd_news_item),
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(200.dp),
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = news.title,
                    maxLines = 2,
                    softWrap = true,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = news.publishedAt,
                    style = MaterialTheme.typography.caption,
                )
                Text(
                    text = news.description,
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

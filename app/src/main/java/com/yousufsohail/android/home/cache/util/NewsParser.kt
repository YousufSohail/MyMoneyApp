package com.yousufsohail.android.home.cache.util

import android.content.Context
import com.google.gson.Gson
import com.yousufsohail.android.home.domain.model.NewsResults
import org.json.JSONObject
import java.nio.charset.Charset

object NewsParser {

    fun parse(context: Context, gson: Gson): List<NewsResults.News> {
        val jsonString = openFile(context)
        return parseJsonString(gson, jsonString)
    }

    private fun openFile(context: Context): String {
        val inputStream = context.assets.open("news_feed.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        return buffer.toString(Charset.defaultCharset())
    }

    private fun parseJsonString(gson: Gson, jsonString: String): List<NewsResults.News> {
        val mainObject = JSONObject(jsonString)
        val newsItems = mutableListOf<NewsResults.News>()
        val newsArray = mainObject.getJSONArray("articles")
        newsArray.forEach { newsObject ->
            val newsItem =
                gson.fromJson(newsObject.toString(), NewsResults.News::class.java)
            newsItems.add(newsItem)
        }

        return newsItems
    }

}

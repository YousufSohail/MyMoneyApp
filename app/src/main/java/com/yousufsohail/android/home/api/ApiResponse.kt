package com.yousufsohail.android.home.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse(
    val data: String
)

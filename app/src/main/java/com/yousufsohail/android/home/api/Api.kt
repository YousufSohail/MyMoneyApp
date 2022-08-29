package com.yousufsohail.android.home.api

import com.yousufsohail.android.home.models.ApiResponse
import retrofit2.http.GET

interface Api {
    @GET("")
    suspend fun getData(

    ): List<ApiResponse>

}

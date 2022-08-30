package com.yousufsohail.android.home.api

import retrofit2.http.GET

interface Api {
    @GET("")
    suspend fun getData(

    ): List<ApiResponse>

}

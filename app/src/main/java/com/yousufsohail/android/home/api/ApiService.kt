package com.yousufsohail.android.home.api

import com.yousufsohail.android.home.models.ApiResponse
import com.yousufsohail.android.network.BaseService
import com.yousufsohail.android.network.Resource
import com.yousufsohail.android.resources.StringResourceProvider
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

interface ApiService {
    suspend fun getData(

    ): Resource<out List<ApiResponse>>
}

class DefaultApiService @Inject constructor(
    private val api: Api,
    stringRes: StringResourceProvider,
    dispatcher: CoroutineDispatcher
) : ApiService, BaseService(dispatcher, stringRes) {

    override suspend fun getData(

    ): Resource<out List<ApiResponse>> {
        return requestApiResource {
            api.getData(


            )
        }
    }
}

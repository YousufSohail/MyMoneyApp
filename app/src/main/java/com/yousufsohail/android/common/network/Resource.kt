package com.yousufsohail.android.common.network

sealed class Resource<T>{
    data class Data<T>(val data : T) : Resource<T>()
    data class Error(val errorMessage : String, val errorCode : Int) : Resource<Nothing>()
}

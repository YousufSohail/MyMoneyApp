package com.yousufsohail.android.home.models

sealed class DataModel {

    data class Data(
       val data : String
    ) : DataModel()


    data class Error(
        val message: String
    ) : DataModel()

    object Loading : DataModel()
}

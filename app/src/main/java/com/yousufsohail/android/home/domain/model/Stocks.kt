package com.yousufsohail.android.home.domain.model

import java.util.*

data class Stocks(
    var id: String = UUID.randomUUID().toString(),
    var symbol: String,
    var price: Double
)

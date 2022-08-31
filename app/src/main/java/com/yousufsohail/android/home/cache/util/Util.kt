package com.yousufsohail.android.home.cache.util

import java.math.RoundingMode
import java.text.DecimalFormat

fun roundOffDecimal(number: Double): Double {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING
    return df.format(number).toDouble()
}

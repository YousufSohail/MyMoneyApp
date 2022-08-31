package com.yousufsohail.android.home.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yousufsohail.android.home.domain.model.Stocks

@Composable
fun StockTicker(stocks: List<Stocks>) {
    Row(modifier = Modifier.fillMaxWidth()) {
        stocks.forEach { stock ->
            Box(modifier = Modifier.size(100.dp)) {
                Text(text = stock.symbol + stock.price)
            }
        }
    }
}

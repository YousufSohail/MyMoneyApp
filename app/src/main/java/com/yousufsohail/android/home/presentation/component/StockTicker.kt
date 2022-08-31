package com.yousufsohail.android.home.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.yousufsohail.android.home.domain.model.Stocks

@Composable
fun StockTicker(stocks: List<Stocks>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "My Portfolio Update", style = MaterialTheme.typography.h5)
        LazyRow {
            items(stocks) { stock ->
                Row(
                    modifier = Modifier
                        .size(100.dp)
                        .padding(start = 8.dp)
                ) {
                    Text(text = stock.symbol)
                    Text(text = stock.price)
                }
            }
        }
    }
}

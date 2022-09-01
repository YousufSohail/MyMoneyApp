package com.yousufsohail.android.home.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.yousufsohail.android.R
import com.yousufsohail.android.home.domain.model.Stocks

@Composable
fun StockTicker(stocks: List<Stocks>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Text(text = stringResource(R.string.ticker_section_header), style = MaterialTheme.typography.h5)
        LazyRow {
            items(stocks) { stock ->
                Card(
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = MaterialTheme.colors.secondary,
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Text(
                            text = stock.symbol,
                            style = MaterialTheme.typography.subtitle1,
                            fontFamily = FontFamily.Monospace
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Text(
                            text = "$${stock.price}",
                            style = MaterialTheme.typography.body1,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        }
    }
}

package com.example.cripper.presentation.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cripper.domain.model.Coin

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClicked: (Coin) -> Unit
) {
    Surface(modifier = Modifier.fillMaxWidth(),
        shadowElevation = 3.dp) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clickable { onItemClicked(coin) }
            .background(color = MaterialTheme.colorScheme.surfaceColorAtElevation(8.dp))
            .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {

            Text(
                text = "${coin.rank}. ${coin.name}  ${coin.symbol}",
                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp),
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = if (coin.isActive) "Active" else "Inactive",
                modifier = Modifier.align(alignment = Alignment.CenterVertically),
                color = Color.Red,
                fontStyle = FontStyle.Italic,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListPrev () {

    CoinListItem(coin = Coin("10",
        isActive = true,
        name = "KaiCoin",
        rank = 9,
        symbol = "K"), onItemClicked = {})
}

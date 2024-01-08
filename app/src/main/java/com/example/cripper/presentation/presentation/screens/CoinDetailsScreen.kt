package com.example.cripper.presentation.presentation.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.cripper.presentation.presentation.viewModels.CoinDetailsViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cripper.presentation.presentation.components.CoinTag
import com.example.cripper.presentation.presentation.components.TeamListItem

@Composable
fun CoinDetailsScreen(viewModel : CoinDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.coins?.let { coinDetail ->
            LazyColumn(modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(23.dp)) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${coinDetail.rank}. ${coinDetail.name} (${coinDetail.symbol})",
                            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 23.sp),
                            modifier = Modifier.weight(8f)
                        )
                        Text(
                            text = if (coinDetail.isActive) "Active" else "Inactive",
                            color = Color.Green,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(2f)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))

                    Text(text = coinDetail.description, style = MaterialTheme.typography.bodyLarge)

                    Spacer(modifier = Modifier.height(15.dp))

                   // Text(text = "Tags", style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp,
                       // fontWeight = FontWeight.Bold, color = Color.Green))

                    Spacer(modifier = Modifier.height(25.dp))

                    Text(text = "Team Members", style = MaterialTheme.typography.headlineSmall,
                        color = Color.Green)

                    Spacer(modifier = Modifier.height(15.dp))
                }

                items(coinDetail.team) { teamMembers ->
                    TeamListItem(
                        teamMember = teamMembers,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    )

                    Divider()
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(22.dp)
                    .align(
                        Alignment.Center
                    )
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

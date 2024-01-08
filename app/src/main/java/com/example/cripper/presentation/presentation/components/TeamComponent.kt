package com.example.cripper.presentation.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.cripper.data.dto.TeamMember

@Composable
fun TeamListItem(
    teamMember:TeamMember,
    modifier: Modifier
) {
    Column(verticalArrangement = Arrangement.Center) {
        Text(
            text = teamMember.name,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier= Modifier.height(5.dp))

        Text(
            text = teamMember.position,
            style = MaterialTheme.typography.labelLarge.copy(color = Color.Red),
            fontStyle = FontStyle.Italic
        )
    }

}
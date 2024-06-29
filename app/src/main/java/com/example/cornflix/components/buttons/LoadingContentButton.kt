package com.example.cornflix.components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoadingContentButton(isLoading: Boolean, onClick: () -> Unit){
    Button(
        onClick = onClick,
        enabled = !isLoading,
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF999999)),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                color = Color.White,
                modifier = Modifier.size(20.dp)
            )
        } else {
            Text(text = "Load More")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingContentButtonPreview() {
    var isLoading by remember { mutableStateOf(false) }
    LoadingContentButton(
        isLoading = isLoading,
        onClick = {
            isLoading = !isLoading
        }
    )
}
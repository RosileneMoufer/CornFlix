package com.example.cornflix.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cornflix.components.Card
import com.example.cornflix.ui.theme.tertiary

@Composable
fun FavoritesScreen(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(tertiary)
            .padding(paddingValues)
    ) {
        LazyVerticalGridDemo()
    }
}

@Composable
fun LazyVerticalGridDemo() {
    val list = (1..10).map { it.toString() }
/*
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),

        // content padding
        contentPadding = PaddingValues(16.dp),

        verticalArrangement = Arrangement.spacedBy(8.dp),

        horizontalArrangement = Arrangement.spacedBy(8.dp),

        content = {
            items(list.size) { index ->
                Card(index)
            }
        }
    )

 */
}
package com.example.cornflix.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cornflix.models.MediaModel
import com.example.cornflix.models.movie.MoviesModel
import com.example.cornflix.ui.theme.tertiary
import java.util.Objects


@Composable
fun LazyVerticalGridMovies(listMovies: List<MoviesModel> = listOf(), showCloseButtonCards:Boolean = false){

    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(tertiary),
    ){
        items(listMovies){
            Card(movie = it)
        }
    }
}
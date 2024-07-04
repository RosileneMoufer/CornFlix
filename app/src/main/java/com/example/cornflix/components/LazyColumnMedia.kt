package com.example.cornflix.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.cornflix.components.buttons.RemoveFavoriteButton
import com.example.cornflix.ui.theme.tertiary
import com.example.cornflix.viewmodel.DefaultViewModel
import com.example.cornflix.viewmodel.FavoritesViewModel
import com.example.cornflix.viewmodel.MoviesUiState
import com.example.cornflix.viewmodel.MoviesViewModel

@SuppressLint("UnrememberedMutableState", "MutableCollectionMutableState")
@Composable
fun LazyColumnMedia(
    navController: NavController,
    defaultViewModel: DefaultViewModel,
) {
    val isFavorite = defaultViewModel.javaClass.name.lowercase().contains("favorites")

    var page: Int by mutableIntStateOf(1)

    var listOfMedias by remember {
        mutableStateOf(defaultViewModel.defaultListResponse.toMutableStateList())
    }

    val scrollState = rememberLazyGridState()

    val isItemReachEndScroll by remember {
        derivedStateOf {
            scrollState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == scrollState.layoutInfo.totalItemsCount - 1
        }
    }

    LaunchedEffect(key1 = isItemReachEndScroll, block = {
        page++
        defaultViewModel.getMoreMedias(page)
    })

    LazyVerticalGrid(
        state = scrollState,
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(tertiary),
    ) {
        if (isFavorite)
            itemsIndexed(listOfMedias) { _, item ->
                Box {
                    Card(
                        mediaModel = item, navController
                    )
                    RemoveFavoriteButton(
                        iconHeight = 32.dp,
                        onClick = {
                            val type = if (item.javaClass.name.lowercase().contains("movie")) {
                                "movie"
                            } else {
                                "tv"
                            }

                            defaultViewModel.removeFavorites(
                                mediaId = item.id,
                                mediaType = type
                            )

                            val mediasToRemove = listOfMedias.find {
                                it.id == item.id
                            }

                            listOfMedias = listOfMedias.also {
                                it.remove(mediasToRemove)
                            }
                        })
                }
            } else itemsIndexed(defaultViewModel.defaultListResponse) { _, item ->
            Card(mediaModel = item, navController)
        }
    }
}
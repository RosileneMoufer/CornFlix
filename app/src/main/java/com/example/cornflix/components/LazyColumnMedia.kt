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
import androidx.navigation.NavController
import com.example.cornflix.components.buttons.RemoveFavoriteButton
import com.example.cornflix.ui.theme.tertiary
import com.example.cornflix.viewmodel.DefaultViewModel

@SuppressLint("UnrememberedMutableState", "MutableCollectionMutableState")
@Composable
fun LazyColumnMedia(
    navController: NavController,
    defaultViewModel: DefaultViewModel,
) {
    val isFavorite = defaultViewModel.javaClass.name.lowercase().contains("favorites")

    var listOfMedias by remember {
        mutableStateOf(defaultViewModel.defaultListResponse.toMutableStateList())
    }

    var page: Int by mutableIntStateOf(1)

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
        itemsIndexed(listOfMedias) { _, item ->

            if (isFavorite) Box {
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

                        val midiasToRemove = listOfMedias.find {
                            it.id == item.id
                        }

                        listOfMedias = listOfMedias.also {
                            it.remove(midiasToRemove)
                        }
                    })
            } else Card(mediaModel = item, navController)
        }
    }
}
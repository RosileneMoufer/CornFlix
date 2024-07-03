package com.example.cornflix.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cornflix.ui.theme.tertiary
import com.example.cornflix.model.media.MediaModel
import com.example.cornflix.viewmodel.DefaultViewModel
import com.example.cornflix.viewmodel.FavoritesViewModel


@SuppressLint("UnrememberedMutableState")
@Composable
fun LazyColumnMedia(
    navController: NavController,
    defaultViewModel: DefaultViewModel,
) {
    val isFavorite = defaultViewModel.javaClass.name.lowercase().contains("favorites")
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
        columns = GridCells.Adaptive(128.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(tertiary),
    ) {
        itemsIndexed(defaultViewModel.defaultListResponse) { _, item ->
            if (isFavorite) Card(
                mediaModel = item, navController, defaultViewModel
            ) else Card(mediaModel = item, navController)
        }
    }
}
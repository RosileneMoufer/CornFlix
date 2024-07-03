package com.example.cornflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cornflix.components.topbar.TopAppBar
import com.example.cornflix.constants.ItemsMenu
import com.example.cornflix.model.media.MediaModel
import com.example.cornflix.screen.DetailsMediaScreen
import com.example.cornflix.screen.FavoritesScreen
import com.example.cornflix.screen.MediaScreen
import com.example.cornflix.screen.MovieScreen
import com.example.cornflix.screen.SeriesScreen
import com.example.cornflix.ui.theme.CornFlixTheme
import com.example.cornflix.viewmodel.FavoritesViewModel
import com.example.cornflix.viewmodel.HomeScreenViewModel
import com.example.cornflix.viewmodel.MediaViewModel
import com.example.cornflix.viewmodel.MoviesViewModel
import com.example.cornflix.viewmodel.SeriesViewModel

class MainActivity : ComponentActivity() {
    private val homeScreenViewModel by viewModels<HomeScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CornFlixTheme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier
                        .systemBarsPadding()
                        .fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            navController,
                            homeScreenViewModel = homeScreenViewModel
                        )
                    },
                ) { innerPadding ->
                    Nav(innerPadding, navController)
                }
            }
        }
    }
}

@Composable
fun Nav(
    innerPadding: PaddingValues,
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = ItemsMenu.HOME.name) {
        composable(route = ItemsMenu.HOME.name) {
            val mediaViewModel: MediaViewModel = viewModel<MediaViewModel>()
            MediaScreen(
                innerPadding = innerPadding,
                mediaUiState = mediaViewModel.mediaUiState,
                navController,
                mediaViewModel
            )
        }
        composable(route = ItemsMenu.MOVIES.name) {
            val moviesViewModel: MoviesViewModel = viewModel<MoviesViewModel>()
            MovieScreen(
                innerPadding = innerPadding,
                moviesUiState = moviesViewModel.moviesUiState,
                navController,
                moviesViewModel
            )
        }
        composable(route = ItemsMenu.SERIES.name) {
            val seriesViewModel: SeriesViewModel = viewModel<SeriesViewModel>()
            SeriesScreen(
                innerPadding = innerPadding,
                seriesUiState = seriesViewModel.seriesUiState,
                navController,
                seriesViewModel
            )
        }
        composable(route = ItemsMenu.DETAILS.name) {
            val results =
                navController.previousBackStackEntry?.savedStateHandle?.get<MediaModel>("media")
            if (results != null) {
                DetailsMediaScreen(paddingValues = innerPadding, mediaModel = results)
            } else {
                // exibe tela "Not found"
            }
        }
        composable(route = ItemsMenu.FAVORITES.name) {
            val favoritesViewModel: FavoritesViewModel = viewModel<FavoritesViewModel>()
            FavoritesScreen(
                innerPadding = innerPadding,
                favoritesUiState = favoritesViewModel.getFavoritesUiState,
                navController,
                favoritesViewModel
            )
        }
    }
}
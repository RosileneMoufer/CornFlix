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
import com.example.cornflix.screen.MediaScreen
import com.example.cornflix.screen.MovieScreen
import com.example.cornflix.screen.SeriesScreen
import com.example.cornflix.ui.theme.CornFlixTheme
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
fun Nav(innerPadding: PaddingValues, navController: NavHostController) {
    NavHost(navController = navController, startDestination = ItemsMenu.Home.name) {
        composable(route = ItemsMenu.Home.name) {
            val moviesViewModel: MediaViewModel = viewModel<MediaViewModel>()
            MediaScreen(
                innerPadding = innerPadding,
                mediaUiState = moviesViewModel.moviesUiState,
                navController
            )
        }
        composable(route = ItemsMenu.Movies.name) {
            val moviesViewModel: MoviesViewModel = viewModel<MoviesViewModel>()
            MovieScreen(
                innerPadding = innerPadding,
                moviesUiState = moviesViewModel.moviesUiState,
                navController
            )
        }
        composable(route = ItemsMenu.Series.name) {
            val seriesViewModel: SeriesViewModel = viewModel<SeriesViewModel>()
            SeriesScreen(
                innerPadding = innerPadding,
                seriesUiState = seriesViewModel.seriesUiState,
                navController
            )
        }
        composable(route = ItemsMenu.Details.name) {
            val mediaViewModel: MediaViewModel = viewModel<MediaViewModel>()
            //DetailsMediaScreen(mediaModel = mediaViewModel, paddingValues = innerPadding)

        }
    }
}
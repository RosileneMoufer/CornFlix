package com.example.cornflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cornflix.components.topbar.TopAppBar
import com.example.cornflix.screen.MovieScreen
import com.example.cornflix.screen.SeriesScreen
import com.example.cornflix.ui.theme.CornFlixTheme
import com.example.cornflix.viewmodel.HomeScreenViewModel
import com.example.cornflix.viewmodel.MoviesViewModel
import com.example.cornflix.viewmodel.SeriesViewModel

class MainActivity : ComponentActivity() {
    private val homeScreenViewModel by viewModels<HomeScreenViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CornFlixTheme {
                Scaffold(
                    modifier = Modifier
                        .systemBarsPadding()
                        .fillMaxSize(),
                    topBar = { TopAppBar(homeScreenViewModel = homeScreenViewModel) }) { innerPadding ->
                    val moviesViewModel: MoviesViewModel = viewModel<MoviesViewModel>()
                    MovieScreen(innerPadding = innerPadding, moviesUiState = moviesViewModel.moviesUiState)
                    /*val seriesViewModel: SeriesViewModel = viewModel<SeriesViewModel>()
                    SeriesScreen(innerPadding = innerPadding, seriesUiState = seriesViewModel.seriesUiState)*/
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    CornFlixTheme {
        Greeting("Android")

    }
}
package com.singlepointsol.retrofitdemo

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun AlbumScreen(viewModel: AlbumViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val albums by viewModel.albumsLiveData.collectAsState(initial = null)

    // UI to display albums
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Albums", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        albums?.let { response ->
            if (response.isSuccessful) {
                response.body()?.forEach { album ->
                    Text(text = "Album: ${album.title}", style = MaterialTheme.typography.bodyLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            } else {
                Text("Error: ${response.code()}", color = MaterialTheme.colorScheme.error)
            }
        } ?: Text("Loading...", style = MaterialTheme.typography.bodyLarge)
    }
}

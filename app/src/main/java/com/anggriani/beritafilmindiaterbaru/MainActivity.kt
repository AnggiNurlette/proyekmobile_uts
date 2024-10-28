package com.anggriani.beritafilmindiaterbaru

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anggriani.beritafilmindiaterbaru.data.Datasource
import com.anggriani.beritafilmindiaterbaru.model.Film
import com.anggriani.beritafilmindiaterbaru.ui.theme.BeritaFilmIndiaTerbaruTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeritaFilmIndiaTerbaruTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FilmApp()
                }
            }
        }
    }
}

@Composable
fun FilmApp() {
    FilmList(
        filmList = Datasource().loadFilms(),
    )
}

@Composable
fun FilmList(filmList: List<Film>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(filmList) { film ->
            FilmCard(
                film = film,
                modifier = Modifier.padding(8.dp),
                onClick = { /* Handle click here */ }
            )
        }
    }
}

@Composable
fun FilmCard(film: Film, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(
        modifier = modifier.clickable(onClick = onClick)
    ) {
        Column {
            Image(
                painter = painterResource(film.imageResourceId),
                contentDescription = stringResource(film.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(film.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview
@Composable
private fun FilmCardPreview() {
    FilmCard(Film(R.string.film_title_1, R.drawable.gambar1), onClick = {})
}
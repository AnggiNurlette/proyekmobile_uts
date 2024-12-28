package com.anggriani.beritafilmindiaterbaru

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.anggriani.beritafilmindiaterbaru.data.Datasource
import com.anggriani.beritafilmindiaterbaru.model.Film

class FilmDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colorScheme.background) {
                val filmId = intent.getIntExtra("FILM_ID", 0)
                FilmDetail(filmId)
            }
        }
    }
}

@Composable
fun FilmDetail(filmId: Int) {
    val film = Datasource().loadFilms().find { it.id == filmId }

    film?.let {
        Column(modifier = Modifier.padding(16.dp)) {
            // Menampilkan gambar dan nama film
            Image(
                painter = painterResource(it.imageResourceId),
                contentDescription = stringResource(it.stringResourceId),
                modifier = Modifier.fillMaxWidth().height(300.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(it.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineMedium
            )

            // Memanggil slide kedua untuk menampilkan detail film
            FilmDetailSlide(it)
        }
    } ?: run {
        Text(text = "Film tidak ditemukan.", style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun FilmDetailSlide(film: Film) {
    Column(modifier = Modifier.padding(16.dp)) {
        // Menampilkan Sinopsis
        Text(
            text = "Sinopsis: ${film.synopsis}",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Menampilkan Tahun Rilis
        Text(
            text = "Tahun Rilis: ${film.releaseYear}",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Menampilkan Berita Terbaru
        Text(
            text = "Berita: ${film.news}",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

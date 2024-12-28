package com.anggriani.beritafilmindiaterbaru.data

import com.anggriani.beritafilmindiaterbaru.R
import com.anggriani.beritafilmindiaterbaru.model.Film

class Datasource {
    fun loadFilms(): List<Film> {
        return listOf(
            Film(1, R.string.film_title_1, R.drawable.gambar1, "Sinopsis film 1", "2024", "Berita terbaru tentang film 1"),
            Film(2, R.string.film_title_2, R.drawable.gambar2, "Sinopsis film 2", "2024", "Berita terbaru tentang film 2"),
            Film(3, R.string.film_title_3, R.drawable.gambar3, "Sinopsis film 3", "2024", "Berita terbaru tentang film 3"),
            Film(4, R.string.film_title_4, R.drawable.gambar4, "Sinopsis film 4", "2018", "Berita terbaru tentang film 4"),
            Film(5, R.string.film_title_5, R.drawable.gambar5, "Sinopsis film 5", "1990", "Berita terbaru tentang film 5"),
        )
    }
}

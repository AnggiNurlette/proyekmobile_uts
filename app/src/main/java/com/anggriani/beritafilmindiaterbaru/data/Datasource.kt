package com.anggriani.beritafilmindiaterbaru.data

import com.anggriani.beritafilmindiaterbaru.R
import com.anggriani.beritafilmindiaterbaru.model.Film

class Datasource {
    fun loadFilms(): List<Film> {
        return listOf(
            Film(R.string.film_title_1, R.drawable.gambar1),
            Film(R.string.film_title_2, R.drawable.gambar2),
            Film(R.string.film_title_3, R.drawable.gambar3),
            Film(R.string.film_title_4, R.drawable.gambar4),
            Film(R.string.film_title_5, R.drawable.gambar5)
        )
    }
}
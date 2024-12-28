package com.anggriani.beritafilmindiaterbaru.model

data class Film(
    val id: Int,
    val stringResourceId: Int,
    val imageResourceId: Int,
    val synopsis: String,
    val releaseYear: String,
    val news: String
)
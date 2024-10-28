package com.anggriani.beritafilmindiaterbaru.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Film(
    @StringRes val stringResourceId: Int,  // ID untuk resource string (judul film)
    @DrawableRes val imageResourceId: Int   // ID untuk resource gambar (poster film)
)
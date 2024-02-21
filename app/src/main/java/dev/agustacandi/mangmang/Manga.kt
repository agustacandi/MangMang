package dev.agustacandi.mangmang

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Manga(
    val title: String,
    val author: String,
    val score: String,
    val synopsis: String,
    val genres: String,
    val publishedDate: String,
    val image: String,
    val charaImage: String,
    val charaName: String,
    val charaImage2: String,
    val charaName2: String,
    val charaImage3: String,
    val charaName3: String
) : Parcelable

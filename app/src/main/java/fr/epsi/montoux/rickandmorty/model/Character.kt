package fr.epsi.montoux.rickandmorty.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Character(
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: Location,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
) : Parcelable

@Parcelize
data class Location(
    val name: String,
    val url: String
) : Parcelable

data class CharacterResponse(
    val results: List<Character>
)
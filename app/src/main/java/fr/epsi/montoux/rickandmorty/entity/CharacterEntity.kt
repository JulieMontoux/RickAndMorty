package fr.epsi.montoux.rickandmorty.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import fr.epsi.montoux.rickandmorty.model.Character
import fr.epsi.montoux.rickandmorty.model.Location
import fr.epsi.montoux.rickandmorty.model.Origin
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val originName: String,
    val originUrl: String,
    val locationName: String,
    val locationUrl: String,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
) : Parcelable

fun CharacterEntity.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        origin = Origin(name = originName, url = originUrl),
        location = Location(name = locationName, url = locationUrl),
        image = image,
        episode = episode,
        url = url,
        created = created
    )
}

fun Character.toCharacterEntity(): CharacterEntity {
    return CharacterEntity(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        originName = origin.name,
        originUrl = origin.url,
        locationName = location.name,
        locationUrl = location.url,
        image = image,
        episode = episode,
        url = url,
        created = created
    )
}

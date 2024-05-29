package fr.epsi.montoux.rickandmorty.model

data class Character(
    val id: Int,
    val name: String
)

data class CharacterResponse(
    val results: List<Character>
)
package fr.epsi.montoux.rickandmorty.network

import fr.epsi.montoux.rickandmorty.model.Character
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// Interface pour définir les routes de l'API
interface RickAndMortyApiService {
    @GET("character")
    suspend fun getCharacters(): CharacterResponse
}

// Classe pour gérer la réponse de l'API
data class CharacterResponse(
    val results: List<Character>
)

// Singleton pour créer l'instance Retrofit
object RetrofitInstance {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    val api: RickAndMortyApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyApiService::class.java)
    }
}
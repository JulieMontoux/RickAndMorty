package fr.epsi.montoux.rickandmorty.network

import fr.epsi.montoux.rickandmorty.model.Character
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// Interface pour définir les routes de l'API
interface RickAndMortyApiService {
    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int = 1): CharacterResponse
}

// Classe pour gérer la réponse de l'API
data class CharacterResponse(
    val info: PageInfo,
    val results: List<Character>
)

data class PageInfo(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
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

package fr.epsi.montoux.rickandmorty.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.epsi.montoux.rickandmorty.model.Character
import fr.epsi.montoux.rickandmorty.network.RetrofitInstance
import kotlinx.coroutines.launch

class CharactersListViewModel : ViewModel() {

    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> get() = _characters

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getCharacters()
                _characters.value = response.results
            } catch (e: Exception) {
                _characters.value = emptyList()
                _errorMessage.value = "Une erreur est survenue: ${e.message}"
            }
        }
    }
}
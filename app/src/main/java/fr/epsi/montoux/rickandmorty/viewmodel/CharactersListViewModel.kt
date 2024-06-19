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

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private var _currentPage = 1
    val currentPage: Int get() = _currentPage

    private var _totalPages = 1
    val totalPages: Int get() = _totalPages

    init {
        fetchCharacters(_currentPage)
    }

    private fun fetchCharacters(page: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getCharacters(page)
                _currentPage = page
                _totalPages = response.info.pages
                val currentCharacters = _characters.value.orEmpty()
                _characters.value = currentCharacters + response.results
            } catch (e: Exception) {
                _errorMessage.value = "Une erreur est survenue: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun fetchNextPage() {
        if (_currentPage < _totalPages && _isLoading.value == false) {
            fetchCharacters(_currentPage + 1)
        }
    }
}

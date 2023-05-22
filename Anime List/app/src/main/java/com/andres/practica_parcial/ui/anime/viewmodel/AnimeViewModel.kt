package com.andres.practica_parcial.ui.anime.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.andres.practica_parcial.AnimeReviewerApplication
import com.andres.practica_parcial.data.model.AnimeModel
import com.andres.practica_parcial.repositories.AnimeRepository

class AnimeViewModel(private val repository: AnimeRepository) : ViewModel() {

    // Live Data
    var name = MutableLiveData("")
    var category = MutableLiveData("")
    var description = MutableLiveData("")
    var qualification = MutableLiveData("")
    var status = MutableLiveData("")


    // Funciones del View Model
    fun getAnimes() = repository.getAnimes()

    fun addAnimes(anime : AnimeModel) = repository.addAnimes(anime)

    // Validara que se haya enviado información en los EditText.
    fun createAnime() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }
        val anime = AnimeModel(
            name.value!!,
            category.value!!,
            description.value!!,
            qualification.value!!
        )

        addAnimes(anime)
        clearData()

        status.value = ANIME_CREATED
    }

    // Validación para el IF.
    private fun validateData() : Boolean {
        when {
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            qualification.value.isNullOrEmpty() -> return false
        }
        return true
    }

    // Limpia los EditText.
    fun clearData() {
        name.value = ""
        category.value = ""
        description.value = ""
        qualification.value = ""
    }

    // Limpia el status.
    fun clearStatus() {
        status.value = INACTIVE
    }

    fun setSelectedAnime(anime : AnimeModel) {
        name.value = anime.name
        category.value = anime.category
        description.value = anime.description
        qualification.value = anime.qualification
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as AnimeReviewerApplication
                AnimeViewModel(app.animeRepository)
            }
        }

        // Validaciones
        const val ANIME_CREATED = "Anime Created!"
        const val WRONG_INFORMATION = "Wrong Information :("
        const val INACTIVE = ""
    }
}
package com.andres.practica_parcial

import android.app.Application
import com.andres.practica_parcial.data.animes
import com.andres.practica_parcial.repositories.AnimeRepository

class AnimeReviewerApplication : Application(){
    val animeRepository : AnimeRepository by lazy {
        AnimeRepository(animes)
    }
}
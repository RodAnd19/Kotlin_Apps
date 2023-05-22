package com.andres.practica_parcial.repositories

import com.andres.practica_parcial.data.model.AnimeModel

class AnimeRepository(private val animes : MutableList<AnimeModel>) {

    fun getAnimes() = animes

    fun addAnimes(anime : AnimeModel) = animes.add(anime)
}
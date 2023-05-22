package com.andres.practica_parcial.data

import com.andres.practica_parcial.data.model.AnimeModel

var name = "Dragon Ball Z"
var category = "Oni Chan"
var description = "Un valiente joven con poderes increíbles se aventura hacia un viaje místico en tierras exóticas llenas de guerreros nobles, princesas hermosas, monstruos mutantes, extraterrestres y crueles ejércitos."
var qualification = "9.4"

var animes = mutableListOf(
    AnimeModel(name, category, description, qualification)
)
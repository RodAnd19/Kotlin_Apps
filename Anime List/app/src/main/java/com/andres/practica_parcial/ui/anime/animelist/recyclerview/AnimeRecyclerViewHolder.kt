package com.andres.practica_parcial.ui.anime.animelist.recyclerview

import androidx.recyclerview.widget.RecyclerView
import com.andres.practica_parcial.data.model.AnimeModel
import com.andres.practica_parcial.databinding.AnimeItemBinding


class AnimeRecyclerViewHolder(private val binding : AnimeItemBinding) : RecyclerView.ViewHolder(binding.root) {
    // ViewHolder sera el que coloque la informacion en el item del recyclerView.

    fun bind(anime : AnimeModel, clickListener : (AnimeModel) -> Unit) {
        binding.animeTittleTv.text = anime.name
        binding.animeQualificationTv.text = anime.qualification

        binding.animeCard.setOnClickListener {
            clickListener(anime)
        }
    }
}
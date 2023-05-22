package com.andres.practica_parcial.ui.anime.animelist.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andres.practica_parcial.data.model.AnimeModel
import com.andres.practica_parcial.databinding.AnimeItemBinding

class AnimeRecyclerViewAdapter(
    private val clickListener : (AnimeModel) -> Unit
) : RecyclerView.Adapter<AnimeRecyclerViewHolder>() {
    private val animes = ArrayList<AnimeModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeRecyclerViewHolder {
        val binding = AnimeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return animes.size
    }

    override fun onBindViewHolder(holder: AnimeRecyclerViewHolder, position: Int) {
        val anime = animes[position]
        holder.bind(anime, clickListener)
    }

    fun setData(animeList : List<AnimeModel>){
        animes.clear()
        animes.addAll(animeList)
    }
}
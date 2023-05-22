package com.andres.practica_parcial.ui.anime.animelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.andres.practica_parcial.R
import com.andres.practica_parcial.data.model.AnimeModel
import com.andres.practica_parcial.databinding.FragmentAnimeListBinding
import com.andres.practica_parcial.ui.anime.viewmodel.AnimeViewModel
import com.andres.practica_parcial.ui.anime.animelist.recyclerview.AnimeRecyclerViewAdapter

class AnimeListFragment : Fragment() {

    private val animeViewModel : AnimeViewModel by activityViewModels{
        AnimeViewModel.Factory
    }

   // Variable de DataBinding
   private lateinit var binding : FragmentAnimeListBinding

   // Variable para Adapter de RecyclerView
   private lateinit var adapter : AnimeRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.btnCreateNewItem.setOnClickListener {
            animeViewModel.clearData()
            it.findNavController().navigate(R.id.action_animeList_to_addNewAnime)
        }
    }

    private fun showSelectedItem (anime : AnimeModel) {
        animeViewModel.setSelectedAnime(anime)
        findNavController().navigate(R.id.action_animeList_to_animeInformationFragment)
    }

    private fun displayAnimes() {
        adapter.setData(animeViewModel.getAnimes())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView (view: View) {
        binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = AnimeRecyclerViewAdapter { selectedAnime ->
            showSelectedItem(selectedAnime)
        }

        binding.recyclerView.adapter = adapter
        displayAnimes()
    }

}
package com.andres.practica_parcial.ui.anime

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.andres.practica_parcial.databinding.FragmentAnimeInformationBinding
import com.andres.practica_parcial.ui.anime.viewmodel.AnimeViewModel

class AnimeInformationFragment : Fragment() {

    // Variable de DataBinding
    private lateinit var binding : FragmentAnimeInformationBinding

    private val animeViewModel : AnimeViewModel by activityViewModels {
        AnimeViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimeInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = animeViewModel
    }

}
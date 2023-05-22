package com.andres.practica_parcial.ui.anime.newanime

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.andres.practica_parcial.databinding.FragmentAddNewAnimeBinding
import com.andres.practica_parcial.ui.anime.viewmodel.AnimeViewModel


class AddNewAnimeFragment : Fragment() {

    private val animeViewModel : AnimeViewModel by activityViewModels {
        AnimeViewModel.Factory
    }

    // Variable de DabaBinding
    private lateinit var binding : FragmentAddNewAnimeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNewAnimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = animeViewModel
    }

    private fun observeStatus() {
        animeViewModel.status.observe(viewLifecycleOwner) { status ->
            when {
                status.equals(AnimeViewModel.WRONG_INFORMATION) -> {
                    Log.d(APP_TAG, status)
                    animeViewModel.clearStatus()
                }
                status.equals(AnimeViewModel.ANIME_CREATED) -> {
                    Log.d(APP_TAG, status)
                    Log.d(APP_TAG, animeViewModel.getAnimes().toString())

                    animeViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

    companion object {
        const val APP_TAG = "APP_TAG"
    }
}
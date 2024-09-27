package com.example.jolboldu_hw_diroom.ui.fragment.add

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.jolboldu_hw_diroom.R
import com.example.jolboldu_hw_diroom.data.room.model.NoteModel
import com.example.jolboldu_hw_diroom.databinding.FragmentAddBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : Fragment() {

    private val viewModel: AddViewModel by viewModels()
    private val binding by lazy {
        FragmentAddBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        add()
    }

    private fun add() {
        viewModel.insert(
            NoteModel(
                title = binding.etTitle.text.toString(),
                description = binding.etDescription.text.toString()
            )
        )
        binding.btn.setOnClickListener{
            findNavController().navigateUp()
        }
    }
}
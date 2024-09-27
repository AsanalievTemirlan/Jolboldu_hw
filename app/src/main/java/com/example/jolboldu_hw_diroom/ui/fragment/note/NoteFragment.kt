package com.example.jolboldu_hw_diroom.ui.fragment.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.jolboldu_hw_diroom.R
import com.example.jolboldu_hw_diroom.data.room.model.NoteModel
import com.example.jolboldu_hw_diroom.databinding.FragmentNoteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteFragment : Fragment(), NoteAdapter.OnItemLongClickListener {

    private lateinit var adapter: NoteAdapter
    private val viewModel: NoteViewModel by viewModels()
    private val binding by lazy {
        FragmentNoteBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addData()
        listener()
    }

    private fun listener() {
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addFragment)
        }
    }

    private fun addData() {
        adapter = NoteAdapter(this)
        viewModel.getAllNotes().observe(viewLifecycleOwner) { notes ->
            adapter.submitList(notes)
        }
        binding.rvAdd.adapter = adapter
    }

    override fun onItemLongClicked(model: NoteModel) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Delete Note").setMessage("Delete").setPositiveButton("Delete") { _, _ ->
            viewModel.deleteNote(model.id)
        }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .create().show()
    }
}
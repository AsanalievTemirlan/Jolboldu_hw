package com.example.jolboldu_hw_diroom.ui.fragment.note

import androidx.lifecycle.ViewModel
import com.example.jolboldu_hw_diroom.data.room.dao.Dao
import com.example.jolboldu_hw_diroom.data.room.model.NoteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val dao: Dao): ViewModel() {

    fun getAllNotes() = dao.getAllNotes()

    fun deleteNote(id: Int) = dao.deleteNote(id)

}
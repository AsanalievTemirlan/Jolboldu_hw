package com.example.jolboldu_hw_diroom.ui.fragment.add

import androidx.lifecycle.ViewModel
import com.example.jolboldu_hw_diroom.data.room.dao.Dao
import com.example.jolboldu_hw_diroom.data.room.model.NoteModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(private val dao: Dao) : ViewModel() {

    fun insert(model: NoteModel) = dao.insertNote(model)
}
package com.example.jolboldu_hw_diroom.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.jolboldu_hw_diroom.data.room.model.NoteModel

@Dao
interface Dao {

    @Query("SELECT * FROM noteModel")
    fun getAllNotes(): LiveData<List<NoteModel>>

    @Query("DELETE FROM noteModel WHERE id = :id")
    fun deleteNote(id: Int)

    @Insert
    fun insertNote(noteModel: NoteModel)
}
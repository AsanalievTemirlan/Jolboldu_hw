package com.example.jolboldu_hw_diroom.data.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jolboldu_hw_diroom.data.room.dao.Dao
import com.example.jolboldu_hw_diroom.data.room.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDataBase: RoomDatabase() {
    abstract fun noteDao(): Dao
}
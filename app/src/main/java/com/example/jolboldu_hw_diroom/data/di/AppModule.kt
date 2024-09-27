package com.example.jolboldu_hw_diroom.data.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.example.jolboldu_hw_diroom.data.room.dao.Dao
import com.example.jolboldu_hw_diroom.data.room.db.NoteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideOnBoardPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideRoomDataBase(@ApplicationContext context: Context): NoteDataBase =
        Room.databaseBuilder(context, NoteDataBase::class.java, "NoteDataBase")
            .allowMainThreadQueries().build()

    @Provides
    fun provideDao(loveDataBase: NoteDataBase): Dao {
        return loveDataBase.noteDao()
    }
}
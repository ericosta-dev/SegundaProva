package com.example.prova2pdm

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Praia::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun praiaDao(): PraiaDAO
}
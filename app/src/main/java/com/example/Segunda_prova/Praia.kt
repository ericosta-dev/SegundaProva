package com.example.prova2pdm

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "praia_table")
data class Praia(
    var name: String,
    var cidade: String,
    var estado: String,
    var descricao: String,
    var ano: Int,
    var nota: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

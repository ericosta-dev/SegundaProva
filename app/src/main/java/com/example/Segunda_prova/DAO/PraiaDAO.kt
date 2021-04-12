package com.example.prova2pdm

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PraiaDAO {
    // cadastrar
    @Insert
    fun insert(praia: Praia): Long
    // editar
    @Update
    fun update(praia: Praia): Int
    // listar todos
    @Query("SELECT * FROM praia_table")
    fun listAll(): LiveData<List<Praia>>
    // listar por ID
    @Query("SELECT * FROM praia_table WHERE id = :id")
    fun findById(id: Int): Praia
    // excluir
    @Delete
    fun delete(praia: Praia): Int
}
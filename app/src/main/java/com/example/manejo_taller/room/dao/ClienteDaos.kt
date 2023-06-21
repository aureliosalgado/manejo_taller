package com.example.manejo_taller.room.dao

import androidx.room.*
import com.example.manejo_taller.room.modelo.ModeloCliente
import kotlinx.coroutines.flow.Flow
@Dao
interface ClienteDaos {
    @Query("SELECT * FROM cliente")
    fun obtenerCliente(): Flow<List<ModeloCliente>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun guardarCliente(ModeloCliente: ModeloCliente)

    @Update
    fun actualizarCliente(ModeloCliente: ModeloCliente)

    @Query("DELETE from cliente")
    suspend fun eliminarCliente()

    @Delete
    suspend fun eliminarCliente(ModeloCliente: ModeloCliente)
}
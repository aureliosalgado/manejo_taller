package com.example.manejo_taller.room.dao

import androidx.room.*
import com.example.manejo_taller.room.modelo.ModeloCarro
import com.example.manejo_taller.room.modelo.ModeloTipoServicio
import kotlinx.coroutines.flow.Flow

interface Daos {
    @Query("SELECT * FROM Servicio")
    fun obtenerServicio(): Flow<List<ModeloTipoServicio>>
    @Query("SELECT * FROM carro")
    fun obtenerModelo(): Flow<List<ModeloCarro>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun guardarServicio(ModeloTipoServicio: ModeloTipoServicio)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun guardarModelo(ModeloCarro: ModeloCarro)

    @Update
    fun actualizarServicio(ModeloTipoServicio: ModeloTipoServicio)
    @Update
    fun actualizarModelo(ModeloCarro: ModeloCarro)

    @Query("DELETE from Servicio")
    suspend fun eliminarTodoServicio()
    @Query("DELETE from carro")
    suspend fun eliminarTodoModelo()

    @Delete
    suspend fun eliminarServicio(ModeloTipoServicio:ModeloTipoServicio)
    @Delete
    suspend fun eliminarModelo(ModeloCarro:ModeloCarro)
}
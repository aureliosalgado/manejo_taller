package com.example.manejo_taller.room.dao

import androidx.room.*
import com.example.manejo_taller.room.modelo.ModeloTipoServicio
import kotlinx.coroutines.flow.Flow
@Dao
interface TipoServicioDaos {
    @Query("SELECT * FROM servicio_tipo")
    fun obtenerTipoServicio(): Flow<List<ModeloTipoServicio>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun guardarTipoServicio(ModeloTipoServicio: ModeloTipoServicio)

    @Update
    fun actualizarTipoServicio(ModeloTipoServicio: ModeloTipoServicio)

    @Query("DELETE from servicio_tipo")
    suspend fun eliminarTodoServicio()

    @Delete
    suspend fun eliminarTipoServicio(ModeloTipoServicio: ModeloTipoServicio)
}
package com.example.manejo_taller.room.dao
import androidx.room.*
import com.example.manejo_taller.room.modelo.ModeloCarro
import kotlinx.coroutines.flow.Flow
@Dao
interface CarroDaos {
    @Query("SELECT * FROM carro")
    fun obtenerModelo(): Flow<List<ModeloCarro>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun guardarModelo(ModeloCarro: ModeloCarro)

    @Update
    fun actualizarModelo(ModeloCarro: ModeloCarro)

    @Query("DELETE from carro")
    suspend fun eliminarTodoModelo()

    @Delete
    suspend fun eliminarModelo(ModeloCarro:ModeloCarro)

}
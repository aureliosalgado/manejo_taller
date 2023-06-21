package com.example.manejo_taller.room.dao
import androidx.room.*
import com.example.manejo_taller.room.modelo.ModeloServicio
import kotlinx.coroutines.flow.Flow

@Dao
interface ServicioDaos {
    @Query("SELECT * FROM servicio")
    fun obtenerServicio(): Flow<List<ModeloServicio>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun guardarServicio(ModeloServicio: ModeloServicio)

    @Update
    fun actualizarServicio(ModeloServicio: ModeloServicio)

    @Query("DELETE from servicio")
    suspend fun eliminarTodoServicio()

    @Delete
    suspend fun eliminarServicio(ModeloServicio: ModeloServicio)
}
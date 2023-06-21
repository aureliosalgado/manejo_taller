package com.example.manejo_taller.room.Repositorio

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.manejo_taller.room.dao.*
import com.example.manejo_taller.room.modelo.ModeloServicio
import kotlinx.coroutines.flow.Flow

class RepoServicio constructor(
    private val sevicioDaos:ServicioDaos
) {
    fun obtenerServicio(): LiveData<List<ModeloServicio>> =sevicioDaos.obtenerServicio().asLiveData()

    suspend fun guardarServicio(servicio: ModeloServicio){
        sevicioDaos.guardarServicio(servicio)
    }

    suspend fun eliminarServicio(servicio: ModeloServicio){
        sevicioDaos.eliminarServicio(servicio)
    }
}
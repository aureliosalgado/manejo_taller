package com.example.manejo_taller.room.Repositorio

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.manejo_taller.room.dao.TipoServicioDaos
import com.example.manejo_taller.room.modelo.ModeloTipoServicio

class RepoTipoServicio constructor(
    private val tipoServicioDaos: TipoServicioDaos
){
    fun obtenerTipoServicio(): LiveData<List<ModeloTipoServicio>> =tipoServicioDaos.obtenerTipoServicio().asLiveData()

    suspend fun guardarTipoServicio(tipoServicio: ModeloTipoServicio){
        tipoServicioDaos.guardarTipoServicio(tipoServicio)
    }

    suspend fun eliminarTipoServicio(tipoServicio: ModeloTipoServicio){
        tipoServicioDaos.eliminarTipoServicio(tipoServicio)
    }
    suspend fun actualizarTipoServicio(tipoServicio: ModeloTipoServicio){
        tipoServicioDaos.actualizarTipoServicio(tipoServicio)
    }
}
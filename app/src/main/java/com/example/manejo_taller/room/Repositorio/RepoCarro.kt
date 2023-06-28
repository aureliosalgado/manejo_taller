package com.example.manejo_taller.room.Repositorio

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.manejo_taller.room.dao.CarroDaos
import com.example.manejo_taller.room.modelo.ModeloCarro

class RepoCarro constructor(
    private val CarroDaos:CarroDaos
){
    fun obtenerCarro(): LiveData<List<ModeloCarro>> =CarroDaos.obtenerModelo().asLiveData()

    suspend fun guardarCarro(carro: ModeloCarro){
        CarroDaos.guardarModelo(carro)
    }

    suspend fun eliminarCarro(carro: ModeloCarro){
        CarroDaos.eliminarModelo(carro)
    }

    suspend fun actalizarCarro(carro: ModeloCarro){
        CarroDaos.actualizarModelo(carro)
    }
}
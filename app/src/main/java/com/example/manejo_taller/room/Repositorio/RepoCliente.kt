package com.example.manejo_taller.room.Repositorio

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.example.manejo_taller.room.dao.ClienteDaos
import com.example.manejo_taller.room.modelo.ModeloCliente
import kotlinx.coroutines.flow.Flow

class RepoCliente constructor(
    private val ClienteDaos:ClienteDaos
){
    fun obtenerCliente(): LiveData<List<ModeloCliente>> =ClienteDaos.obtenerCliente().asLiveData()

    suspend fun guardarCliente(cliente: ModeloCliente){
        ClienteDaos.guardarCliente(cliente)
    }

    suspend fun eliminarCliente(cliente: ModeloCliente){
        ClienteDaos.eliminarCliente(cliente)
    }
    suspend fun actualizarCliente(cliente: ModeloCliente){
        ClienteDaos.actualizarCliente(cliente)
    }
}

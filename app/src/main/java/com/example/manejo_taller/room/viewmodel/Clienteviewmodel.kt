package com.example.manejo_taller.room.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.manejo_taller.room.Repositorio.RepoCliente
import com.example.manejo_taller.room.modelo.BaseDatosTaller
import com.example.manejo_taller.room.modelo.ModeloCliente
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Clienteviewmodel (application: Application) : AndroidViewModel(application) {
    val listaClientes  : LiveData<List<ModeloCliente>>
    val repository : RepoCliente

    init {
        val clienteDaos = BaseDatosTaller.getDatabase(application).ClienteDaos()
        repository = RepoCliente(clienteDaos)
        listaClientes = repository.obtenerCliente()
    }
    fun insertCliente(cliente: ModeloCliente) =
        viewModelScope.launch(Dispatchers.IO) { repository.guardarCliente(cliente) }

    fun deleteCliente(cliente: ModeloCliente) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.eliminarCliente(cliente)
        }
}
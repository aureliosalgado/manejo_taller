package com.example.manejo_taller.room.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.manejo_taller.room.Repositorio.RepoCarro
import com.example.manejo_taller.room.modelo.BaseDatosTaller
import com.example.manejo_taller.room.modelo.ModeloCarro
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class carroviewmodel (application: Application) : AndroidViewModel(application) {
    val listaCarros  : LiveData<List<ModeloCarro>>
    val repository : RepoCarro

    init {
        val carroDaos = BaseDatosTaller.getDatabase(application).CarroDaos()
        repository = RepoCarro(carroDaos)
        listaCarros = repository.obtenerCarro()
    }
    fun insertCarro(carro: ModeloCarro) =
        viewModelScope.launch(Dispatchers.IO) { repository.guardarCarro(carro) }

    fun deleteCarro(carro: ModeloCarro) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.eliminarCarro(carro)
        }

    fun actualizarCarro(carro: ModeloCarro) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.actalizarCarro(carro)
        }
}
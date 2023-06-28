package com.example.manejo_taller.room.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.manejo_taller.room.Repositorio.RepoServicio
import com.example.manejo_taller.room.dao.ServicioDaos
import com.example.manejo_taller.room.modelo.BaseDatosTaller
import com.example.manejo_taller.room.modelo.ModeloServicio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Servicioviewmodel (application: Application) : AndroidViewModel(application) {
    val listaServicios  : LiveData<List<ModeloServicio>>
    val repository : RepoServicio

    init {
        val servicioDaos = BaseDatosTaller.getDatabase(application).ServicioDaos()
        repository = RepoServicio(servicioDaos)
        listaServicios = repository.obtenerServicio()
    }
    fun insertServicio(servicio: ModeloServicio) =
        viewModelScope.launch(Dispatchers.IO) { repository.guardarServicio(servicio) }

    fun deleteServicio(servicio: ModeloServicio) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.eliminarServicio(servicio)
        }
    fun actualizarServicio(servicio: ModeloServicio) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.actualizarServicio(servicio)
        }
}
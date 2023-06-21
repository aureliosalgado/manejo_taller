package com.example.manejo_taller.room.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.manejo_taller.room.Repositorio.RepoTipoServicio
import com.example.manejo_taller.room.dao.TipoServicioDaos
import com.example.manejo_taller.room.modelo.BaseDatosTaller
import com.example.manejo_taller.room.modelo.ModeloTipoServicio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TipoServicioviewmodel (application: Application) : AndroidViewModel(application) {
    val listaTipoServicios  : LiveData<List<ModeloTipoServicio>>
    val repository : RepoTipoServicio

    init {
        val TipoServicioDaos = BaseDatosTaller.getDatabase(application).TipoServicioDaos()
        repository = RepoTipoServicio(TipoServicioDaos)
        listaTipoServicios = repository.obtenerTipoServicio()
    }
    fun insertTipoServicio(servicio_tipo: ModeloTipoServicio) =
        viewModelScope.launch(Dispatchers.IO) { repository.guardarTipoServicio(servicio_tipo) }

    fun deleteTipoServicio(servicio_tipo: ModeloTipoServicio) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.eliminarTipoServicio(servicio_tipo)
        }
}
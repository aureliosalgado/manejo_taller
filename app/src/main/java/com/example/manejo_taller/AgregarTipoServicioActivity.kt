package com.example.manejo_taller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.example.manejo_taller.databinding.ActivityAgregarModeloBinding
import com.example.manejo_taller.databinding.ActivityAgregarTipoServicioBinding
import com.example.manejo_taller.room.modelo.ModeloCarro
import com.example.manejo_taller.room.modelo.ModeloTipoServicio
import com.example.manejo_taller.room.viewmodel.TipoServicioviewmodel
import com.example.manejo_taller.room.viewmodel.carroviewmodel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AgregarTipoServicioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgregarTipoServicioBinding
    private lateinit var viewModel: TipoServicioviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgregarTipoServicioBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            TipoServicioviewmodel::class.java)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_btn_aceptar) {
            GlobalScope.launch {
                val tipo = ModeloTipoServicio(
                    binding.etTiposervicio.text.toString()
                )
                viewModel.insertTipoServicio(tipo)
                finish()
            }
        } else if(item.itemId == R.id.menu_btn_cancelar)
        {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.aceptar_cancelar, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
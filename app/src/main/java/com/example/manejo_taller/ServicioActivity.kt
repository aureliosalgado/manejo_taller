package com.example.manejo_taller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.manejo_taller.databinding.ActivityAgregarClienteActicityBinding
import com.example.manejo_taller.databinding.ActivityMainBinding
import com.example.manejo_taller.databinding.ActivityServicioBinding
import com.example.manejo_taller.room.modelo.ModeloCliente
import com.example.manejo_taller.room.modelo.ModeloServicio
import com.example.manejo_taller.room.viewmodel.Clienteviewmodel
import com.example.manejo_taller.room.viewmodel.Servicioviewmodel
import com.example.manejo_taller.room.viewmodel.TipoServicioviewmodel
import com.example.manejo_taller.room.viewmodel.carroviewmodel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ServicioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityServicioBinding


    private lateinit var viewModel: Servicioviewmodel
    private lateinit var viewModelCliente: Clienteviewmodel
    private lateinit var viewModelAuto: carroviewmodel
    private lateinit var viewModelTipo: TipoServicioviewmodel

    private  var adapterCliente: ArrayAdapter<String>? = null
    private  var adapterAuto: ArrayAdapter<String>? = null
    private  var adapterTipo: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServicioBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            Servicioviewmodel::class.java)
        viewModelCliente = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            Clienteviewmodel::class.java)
        viewModelAuto = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            carroviewmodel::class.java)
        viewModelTipo = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            TipoServicioviewmodel::class.java)

        observeEvents()
    }

    private fun observeEvents() {
        viewModelCliente.listaClientes.observe(this, Observer { list ->
            list?.let {
                adapterCliente =
                    ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, it.map { a ->
                        a.Nombre + ", " + a.Cedula + ", " + a.Telefono
                    }.toTypedArray());
                binding.Clientespinner.adapter = adapterCliente
                adapterCliente!!.notifyDataSetChanged()
            }
        })
        viewModelAuto.listaCarros.observe(this, Observer { list ->
            list?.let {
                adapterAuto =
                    ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, it.map { a ->
                        a.placa + ", " + a.modelo + ", " + a.anio
                    }.toTypedArray());
                binding.Autospinner.adapter = adapterAuto
                adapterAuto!!.notifyDataSetChanged()
            }
        })
        viewModelTipo.listaTipoServicios.observe(this, Observer { list ->
            list?.let {
                adapterTipo =
                    ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, it.map { a ->
                        a.NombreSer
                    }.toTypedArray());
                binding.TipoServiciospinner.adapter = adapterTipo
                adapterTipo!!.notifyDataSetChanged()
            }
        })
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_btn_aceptar) {
            GlobalScope.launch {
                val cliente = ModeloServicio(
                    0,
                    viewModelAuto.listaCarros.value?.get(binding.Autospinner.selectedItemPosition)?.placa.toString(),
                    viewModelCliente.listaClientes.value?.get(binding.Clientespinner.selectedItemPosition)?.Cedula.toString(),
                    viewModelTipo.listaTipoServicios.value?.get(binding.TipoServiciospinner.selectedItemPosition)?.NombreSer.toString(),
                    binding.etPrecio.text.toString().toInt()
                )
                viewModel.insertServicio(cliente)
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
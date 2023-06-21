package com.example.manejo_taller

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.example.manejo_taller.databinding.ActivityAgregarClienteActicityBinding
import com.example.manejo_taller.room.modelo.ModeloCliente
import com.example.manejo_taller.room.viewmodel.Clienteviewmodel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AgregarClienteActicity : AppCompatActivity() {
    private lateinit var binding:ActivityAgregarClienteActicityBinding
    private lateinit var viewModel:Clienteviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityAgregarClienteActicityBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(Clienteviewmodel::class.java)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_btn_aceptar) {
            GlobalScope.launch {
                val cliente = ModeloCliente(
                    binding.etCedula.text.toString(),
                    binding.etNombre.text.toString(),
                    binding.etTelefono.text.toString().toInt(),
                    binding.etEdad.text.toString().toInt()

                )
                viewModel.insertCliente(cliente)
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
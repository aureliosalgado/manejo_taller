package com.example.manejo_taller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.example.manejo_taller.databinding.ActivityAgregarClienteActicityBinding
import com.example.manejo_taller.databinding.ActivityAgregarModeloBinding
import com.example.manejo_taller.room.modelo.ModeloCarro
import com.example.manejo_taller.room.modelo.ModeloCliente
import com.example.manejo_taller.room.viewmodel.Clienteviewmodel
import com.example.manejo_taller.room.viewmodel.carroviewmodel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AgregarModeloActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgregarModeloBinding
    private lateinit var viewModel: carroviewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityAgregarModeloBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)
        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            carroviewmodel::class.java)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_btn_aceptar) {
            GlobalScope.launch {
                val carro = ModeloCarro(
                    binding.etPlaca.text.toString(),
                    binding.etModelo.text.toString(),
                    binding.etColor.text.toString(),
                    binding.etAnio.text.toString()

                )
                viewModel.insertCarro(carro)
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
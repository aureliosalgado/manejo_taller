package com.example.manejo_taller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.manejo_taller.databinding.ActivityAgregarClienteActicityBinding
import com.example.manejo_taller.databinding.ActivityMainBinding
import com.example.manejo_taller.room.modelo.ModeloServicio
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_cliente)
        {
            val intent = Intent(this, AgregarClienteActicity::class.java)
            startActivity(intent)
        }else if(item.itemId == R.id.menu_auto){
            val intent = Intent(this, AgregarModeloActivity::class.java)
            startActivity(intent)
        }else if(item.itemId == R.id.menu_tipo_servicio){
            val intent = Intent(this, AgregarTipoServicioActivity::class.java)
            startActivity(intent)
        }else if(item.itemId == R.id.menu_servicio){
            val intent = Intent(this, ServicioActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_principal, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
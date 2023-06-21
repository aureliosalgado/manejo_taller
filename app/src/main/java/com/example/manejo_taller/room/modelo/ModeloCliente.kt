package com.example.manejo_taller.room.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "cliente")
data class ModeloCliente(
    @PrimaryKey @ColumnInfo(name = "cedula") val Cedula: String,
    @ColumnInfo(name = "nombre")val Nombre: String,
    @ColumnInfo(name = "telefono")val Telefono: Int,
    @ColumnInfo(name = "edad")val edad: Int,
)

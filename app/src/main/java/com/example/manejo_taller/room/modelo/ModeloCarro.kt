package com.example.manejo_taller.room.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "carro")

data class ModeloCarro(
   @PrimaryKey @ColumnInfo(name = "placa") val placa: String,
    @ColumnInfo(name = "modelo")val modelo: String,
    @ColumnInfo(name = "color")val color: String,
    @ColumnInfo(name = "año")val anio: String,
)
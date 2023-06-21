package com.example.manejo_taller.room.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "servicio_tipo")
data class ModeloTipoServicio(
    @PrimaryKey @ColumnInfo(name = "nombre_ser") val NombreSer: String)


package com.example.manejo_taller.room.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Servicio")
data class ModeloTipoServicio(
    @PrimaryKey(true) @ColumnInfo(name = "NombreSer") val NombreSer: String,
)

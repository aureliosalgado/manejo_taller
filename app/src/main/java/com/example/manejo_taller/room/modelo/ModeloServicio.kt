package com.example.manejo_taller.room.modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "servicio", foreignKeys = [
    ForeignKey(
        entity = ModeloCarro::class,
        parentColumns = arrayOf("placa"),
        childColumns = arrayOf("placa"),
        onDelete = ForeignKey.CASCADE
    ),
    ForeignKey(
        entity = ModeloTipoServicio::class,
        parentColumns = arrayOf("nombre_ser"),
        childColumns = arrayOf("nombre_ser"),
        onDelete = ForeignKey.CASCADE
    ),
    ForeignKey(
        entity = ModeloCliente::class,
        parentColumns = arrayOf("cedula"),
        childColumns = arrayOf("cedula"),
        onDelete = ForeignKey.CASCADE
    )


])
data class ModeloServicio(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "placa") val placa: String,
    @ColumnInfo(name = "cedula") val Cedula: String,
    @ColumnInfo(name = "nombre_ser") val NombreSer: String,
    @ColumnInfo(name = "presio") val presio:Int

)

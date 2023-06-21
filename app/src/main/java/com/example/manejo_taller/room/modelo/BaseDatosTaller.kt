package com.example.manejo_taller.room.modelo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.manejo_taller.room.dao.CarroDaos
import com.example.manejo_taller.room.dao.ClienteDaos
import com.example.manejo_taller.room.dao.ServicioDaos
import com.example.manejo_taller.room.dao.TipoServicioDaos

@Database(entities = [ModeloCarro::class,ModeloTipoServicio::class,ModeloCliente::class, ModeloServicio::class], version = 1)
abstract class BaseDatosTaller :RoomDatabase(){
abstract fun CarroDaos():CarroDaos
abstract fun ServicioDaos():ServicioDaos
abstract fun ClienteDaos():ClienteDaos
abstract fun TipoServicioDaos():TipoServicioDaos

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: BaseDatosTaller? = null

        fun getDatabase(context: Context): BaseDatosTaller {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDatosTaller::class.java,
                    "bdTaller"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }

}

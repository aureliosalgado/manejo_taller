package com.example.manejo_taller.room.modelo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ModeloCarro::class,ModeloTipoServicio::class], version = 1)
abstract class BaseDatosTaller :RoomDatabase(){
    abstract fun ModeloCarro():ModeloCarro
    abstract fun ModeloTipoServicio() : ModeloTipoServicio
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

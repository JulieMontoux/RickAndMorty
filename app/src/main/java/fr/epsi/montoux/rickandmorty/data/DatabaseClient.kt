package fr.epsi.montoux.rickandmorty.data

import android.content.Context
import androidx.room.Room

object DatabaseClient {
    private var instance: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        if (instance == null) {
            instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "rickandmorty_db"
            ).build()
        }
        return instance!!
    }
}

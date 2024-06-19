package fr.epsi.montoux.rickandmorty.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import fr.epsi.montoux.rickandmorty.entity.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}

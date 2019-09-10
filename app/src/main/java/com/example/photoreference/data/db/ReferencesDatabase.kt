package com.example.photoreference.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity
data class Title constructor(val title: String, @PrimaryKey val id: Int = 0)

@Dao
interface ReferencesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTitle(title: Title)

    @Query("select * from Title where id = 0")
    fun loadTitle(): LiveData<Title>
}

@Database(entities = [Title::class], version = 1, exportSchema = false)
abstract class ReferencesDatabase : RoomDatabase() {
    abstract val referencesDao: ReferencesDao
}
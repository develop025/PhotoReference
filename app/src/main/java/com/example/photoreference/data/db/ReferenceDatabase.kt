package com.example.photoreference.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.photoreference.data.db.tables.Category
import com.example.photoreference.data.db.tables.Title

@Dao
interface ReferenceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: Category)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTitle(title: Title)

    @Query("select * from categories")
    fun loadCategories(): LiveData<List<Category>>

    @Query("select * from titles where categoryId = :id")
    fun getTitle(id: Int): LiveData<List<Title>>
}

@Database(entities = [Category::class, Title::class], version = 1, exportSchema = false)
abstract class ReferenceDatabase : RoomDatabase() {
    abstract val referenceDao: ReferenceDao
}
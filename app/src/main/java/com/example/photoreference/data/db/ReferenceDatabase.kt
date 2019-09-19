package com.example.photoreference.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.photoreference.data.db.tables.Category
import com.example.photoreference.data.db.tables.TitleCat
import com.example.photoreference.data.db.tables.TitleTypeConverter

@Dao
interface ReferenceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: Category)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTitle(titleCat: TitleCat)

    @Query("select * from categories")
    fun loadCategories(): LiveData<List<Category>>

    @Query("select * from titles where categoryId = :id")
    fun getTitle(id: Int): LiveData<List<TitleCat>>
}

@Database(entities = [Category::class, TitleCat::class], version = 1, exportSchema = false)
@TypeConverters(TitleTypeConverter::class)
abstract class ReferenceDatabase : RoomDatabase() {
    abstract val referenceDao: ReferenceDao
}
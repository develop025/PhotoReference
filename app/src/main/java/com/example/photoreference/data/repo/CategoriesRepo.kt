package com.example.photoreference.data.repo

import android.graphics.Point
import androidx.lifecycle.distinctUntilChanged
import com.example.photoreference.data.datasource.CategoriesRemoteDataSource
import com.example.photoreference.data.db.ReferenceDao
import com.example.photoreference.data.resultLiveData
import timber.log.Timber

const val defaultLanguage = "ua"

class CategoriesRepo(
    private val categoriesRemoteDataSource: CategoriesRemoteDataSource,
    private val referenceDao: ReferenceDao
) {
    lateinit var language: String
    lateinit var imageSize: Point

    fun observeCategories() = resultLiveData(
        databaseQuery = { referenceDao.loadCategories() },
        networkCall = { categoriesRemoteDataSource.getMenuItems() },
        saveCallResult = {
            it.gitCategories?.forEach { category ->
                Timber.tag("myapp").d("result: ${category.name.toString()}")
                referenceDao.insertCategory(category)
                category.title?.forEach { title ->
                    title.categoryId = category.id
                    referenceDao.insertTitle(title)
                }
            }
        }).distinctUntilChanged()

    fun observeTitle(categoryId: Int) = referenceDao.getTitle(categoryId, language)
    fun observeDefaultTitle(categoryId: Int) = referenceDao.getTitle(categoryId, defaultLanguage)
}
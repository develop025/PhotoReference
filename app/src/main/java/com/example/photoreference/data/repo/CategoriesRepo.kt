package com.example.photoreference.data.repo

import android.graphics.Point
import androidx.lifecycle.LiveData
import androidx.lifecycle.distinctUntilChanged
import com.example.photoreference.data.datasource.CategoriesRemoteDataSource
import com.example.photoreference.data.db.ReferenceDao
import com.example.photoreference.data.db.tables.Category
import com.example.photoreference.data.menu.GitCategories
import com.example.photoreference.data.resultLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class CategoriesRepo(
    private val categoriesRemoteDataSource: CategoriesRemoteDataSource,
    private val referenceDao: ReferenceDao
) {
    lateinit var language: String
    lateinit var imageSize: Point

    /* var categoryList: LiveData<List<Category>> = referenceDao.loadCategories()

     *//*init {
        updateCategories()
    }*/

    fun observeCategories() = resultLiveData(
        databaseQuery = { referenceDao.loadCategories() },
        networkCall = { categoriesRemoteDataSource.getMenuItems() },
        saveCallResult = {
            it.gitCategories?.forEach { category ->
                Timber.tag("myapp").d("result: ${category.name.toString()}")
                //referenceDao.insertCategory(category.category)
            }
        }).distinctUntilChanged()

    /*private fun updateCategories() {
        githubService.getMenuItems().enqueue(object : Callback<GitCategories> {
            override fun onFailure(call: Call<GitCategories>, t: Throwable) {
                //todo get menu error
            }

            override fun onResponse(call: Call<GitCategories>, response: Response<GitCategories>) {
                response.body()?.gitCategories?.forEach {
                    db.referenceDao.insertCategory(it.category)
                    it.titles?.forEach { title ->
                        db.referenceDao.insertTitle(title)
                    }
                }
            }
        })
    }

    fun getTitle(category: Category) = db.referenceDao.getTitle(category.id)*/
}
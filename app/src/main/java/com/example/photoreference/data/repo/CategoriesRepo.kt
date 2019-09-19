package com.example.photoreference.data.repo

import android.graphics.Point
import androidx.lifecycle.distinctUntilChanged
import com.example.photoreference.data.datasource.CategoriesRemoteDataSource
import com.example.photoreference.data.db.ReferenceDao
import com.example.photoreference.data.resultLiveData
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
                referenceDao.insertCategory(category)
                category.title?.forEach { title ->
                    title.categoryId = category.id
                    referenceDao.insertTitle(title)
                }
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
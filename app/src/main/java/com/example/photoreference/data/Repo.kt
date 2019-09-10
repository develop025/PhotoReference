package com.example.photoreference.data

import android.graphics.Point
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.photoreference.api.GithubService
import com.example.photoreference.data.db.ReferenceDatabase
import com.example.photoreference.data.db.tables.Category
import com.example.photoreference.data.db.tables.Title
import com.example.photoreference.data.menu.GitCategories
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repo(
    private val githubService: GithubService,
    private val db: ReferenceDatabase
) {
    lateinit var language: String
    lateinit var imageSize: Point

    var categoryList: LiveData<List<Category>> = db.referenceDao.loadCategories()

    init {
        updateCategories()
    }

    private fun updateCategories() {
        githubService.getMenuItems().enqueue(object : Callback<GitCategories> {
            override fun onFailure(call: Call<GitCategories>, t: Throwable) {
                //todo get menu error
            }

            override fun onResponse(call: Call<GitCategories>, response: Response<GitCategories>) {
                response.body()?.categories?.forEach {
                    db.referenceDao.insertCategory(it.category)
                    it.titles?.forEach { title ->
                        db.referenceDao.insertTitle(title)
                    }
                }
            }
        })
    }

    fun getTitle(category: Category) = db.referenceDao.getTitle(category.id)
}
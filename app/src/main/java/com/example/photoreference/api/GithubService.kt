package com.example.photoreference.api

import com.example.photoreference.data.menu.Categories
import retrofit2.Call
import retrofit2.http.GET

interface GithubService {
    @GET("/develop025/references/master/photo.json")
    fun getMenuItems(): Call<Categories>
}
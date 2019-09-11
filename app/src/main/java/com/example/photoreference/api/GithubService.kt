package com.example.photoreference.api

import com.example.photoreference.data.menu.GitCategories
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface GithubService {
    @GET("/develop025/references/master/photo.json")
    fun getMenuItems(): Response<GitCategories>
}
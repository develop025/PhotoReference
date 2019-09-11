package com.example.photoreference.data.datasource

import com.example.photoreference.api.BaseDataSource
import com.example.photoreference.api.GithubService

class CategoriesRemoteDataSource(private val githubService: GithubService) : BaseDataSource() {
    suspend fun getMenuItems() = getResult { githubService.getMenuItems() }
}
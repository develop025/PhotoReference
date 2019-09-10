package com.example.photoreference.api

import com.example.photoreference.data.photo.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrService {

    companion object {
        const val API_KEY = "e52398cf1e4ade2f455cf132a5b3a281"
    }

    @GET("/services/rest/?method=flickr.photos.search&api_key=$API_KEY&format=json&nojsoncallback=1&extras=url_s&safe_search=1")
    fun getPhotos(
        @Query("tags") tags: String,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int
    ): Call<SearchResponse>
}
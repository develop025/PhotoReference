package com.example.photoreference.ui.list.paged

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.photoreference.api.FlickrService
import com.example.photoreference.data.photo.Photo
import com.example.photoreference.data.photo.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotoDataSource(
    private val pixelService: FlickrService
) : PageKeyedDataSource<Int, Photo>() {
    var tag: String = "tag"

    init {
        Log.d("myapp","init PhotoDataSource")
    }
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Photo>
    ) {
        pixelService.getPhotos(tag, 5, 1)
            .enqueue(object : Callback<SearchResponse> {
                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<SearchResponse>,
                    response: Response<SearchResponse>
                ) {
                    response.body()?.photos?.photo?.let {
                        callback.onResult(
                            it,
                            null,
                            2
                        )
                    }
                }
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        pixelService.getPhotos(tag, params.requestedLoadSize, params.key)
            .enqueue(object : Callback<SearchResponse> {
                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<SearchResponse>,
                    response: Response<SearchResponse>
                ) {
                    response.body()?.photos?.photo?.let {
                        callback.onResult(
                            it,
                            params.key + 1
                        )
                    }
                }
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
    }
}
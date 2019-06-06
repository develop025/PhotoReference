package com.example.photoreference.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.photoreference.data.photo.Photo
import com.example.photoreference.ui.list.paged.PhotoDataSourceFactory

class ListViewModel(private val sourceFactory: PhotoDataSourceFactory) : ViewModel() {
    private val pageSize = 5
    private val config = PagedList.Config.Builder()
        .setPageSize(pageSize)
        .setInitialLoadSizeHint(pageSize * 2)
        .setEnablePlaceholders(false)
        .build()

    fun getImages(): LiveData<PagedList<Photo>> {
        return LivePagedListBuilder<Int, Photo>(sourceFactory, config).build()
    }
}
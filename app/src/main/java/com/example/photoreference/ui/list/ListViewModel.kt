package com.example.photoreference.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.photoreference.data.photo.Photo
import com.example.photoreference.ui.list.paged.PhotoDataSource
import com.example.photoreference.ui.list.paged.PhotoDataSourceFactory

class ListViewModel(private val sourceFactory: PhotoDataSourceFactory) : ViewModel() {
    //private val sourceFactory: PhotoDataSourceFactory
    private val pageSize = 5
    private val config = PagedList.Config.Builder()
        .setPageSize(pageSize)
        .setInitialLoadSizeHint(pageSize * 2)
        .setEnablePlaceholders(false)
        .build()

    fun getImages(tag: String): LiveData<PagedList<Photo>> {

       /* val dataSource: PhotoDataSource = PhotoDataSource()
        val sourceFactory: PhotoDataSourceFactory = PhotoDataSourceFactory(dataSource)*/
        sourceFactory.dataSource.tag = tag
        return LivePagedListBuilder<Int, Photo>(sourceFactory, config).build()
    }
}
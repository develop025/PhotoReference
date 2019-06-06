package com.example.photoreference.ui.list.paged

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.photoreference.data.photo.Photo

class PhotoDataSourceFactory(private val dataSource: PhotoDataSource) :
    DataSource.Factory<Int, Photo>() {

    private val dataSourceLiveData = MutableLiveData<PhotoDataSource>()

    override fun create(): DataSource<Int, Photo> {
        dataSourceLiveData.postValue(dataSource)
        return dataSource
    }
}
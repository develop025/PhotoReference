package com.example.photoreference.ui.list.paged

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.example.photoreference.data.Photo

class PhotoDataSourceFactory(private val dataSource: PhotoDataSource) :
    DataSource.Factory<Int, Photo>() {

    private val dataSourceLiveData = MutableLiveData<PhotoDataSource>()

    override fun create(): DataSource<Int, Photo> {
        dataSourceLiveData.postValue(dataSource)
        return dataSource
    }
}
package com.example.photoreference.ui.list.paged

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.photoreference.data.photo.Photo

class PhotoDataSourceFactory(val dataSource: PhotoDataSource) :
    DataSource.Factory<Int, Photo>() {

    init {
        Log.d("myapp","init PhotoDataSourceFactory")
    }
    private val dataSourceLiveData = MutableLiveData<PhotoDataSource>()

    override fun create(): DataSource<Int, Photo> {
        dataSourceLiveData.postValue(dataSource)
        return dataSource
    }
}
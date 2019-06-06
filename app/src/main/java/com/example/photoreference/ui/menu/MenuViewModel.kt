package com.example.photoreference.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.photoreference.api.GithubService
import com.example.photoreference.data.menu.Categories
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuViewModel(private val githubService: GithubService) : ViewModel() {
    private val menu = MutableLiveData<Categories>()

    fun getMenus(): LiveData<Categories> {
        githubService.getMenuItems().enqueue(object : Callback<Categories> {
            override fun onFailure(call: Call<Categories>, t: Throwable) {
                //todo get menu error
            }

            override fun onResponse(call: Call<Categories>, response: Response<Categories>) {
                menu.postValue(response.body())
            }
        })
        return menu
    }
}
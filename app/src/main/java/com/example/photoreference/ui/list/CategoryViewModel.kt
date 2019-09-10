package com.example.photoreference.ui.list

import androidx.lifecycle.ViewModel
import com.example.photoreference.data.Repo

class CategoryViewModel(
    repo: Repo
) : ViewModel() {
    var categoryList = repo.categoryList
}
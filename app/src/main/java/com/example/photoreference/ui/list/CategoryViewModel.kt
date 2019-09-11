package com.example.photoreference.ui.list

import androidx.lifecycle.ViewModel
import com.example.photoreference.data.repo.CategoriesRepo

class CategoryViewModel(
    categoriesRepo: CategoriesRepo
) : ViewModel() {
    var categoryList = categoriesRepo.categoryList
}
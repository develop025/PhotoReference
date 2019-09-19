package com.example.photoreference.ui.list

import androidx.lifecycle.ViewModel
import com.example.photoreference.data.repo.CategoriesRepo

class CategoryViewModel(
    private val categoriesRepo: CategoriesRepo
) : ViewModel() {
    val categoryList by lazy { categoriesRepo.observeCategories() }

    fun getTitle(categoryId: Int) = categoriesRepo.observeTitle(categoryId)

    fun getDefaultTitle(categoryId: Int) = categoriesRepo.observeDefaultTitle(categoryId)
}
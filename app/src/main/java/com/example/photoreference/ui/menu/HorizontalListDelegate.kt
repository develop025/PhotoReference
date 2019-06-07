package com.example.photoreference.ui.menu

import android.content.Context
import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.photoreference.ui.list.ListViewModel
import com.example.photoreference.ui.list.PhotosListAdapter
import kotlinx.android.synthetic.main.fragment_list.view.*

class HorizontalListDelegate(
    val context: Context,
    private val lifecycleOwner: LifecycleOwner,
    private val viewModel: ListViewModel
) {
    private lateinit var photoAdapter: PhotosListAdapter

    fun init(requestTag: String, view: View) {
        initPaged(view)
        showImages(requestTag)
    }

    private fun showImages(requestTag: String) {
        viewModel.getImages("tag").observe(lifecycleOwner, Observer { list ->
            list?.let {
                photoAdapter.submitList(it)
            }
        })
    }

    private fun initPaged(view: View) {
        photoAdapter = PhotosListAdapter()
        //view.recyclerView?.layoutManager = GridLayoutManager(context, 2)
        view.recyclerView?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
       /* val spacingInPixels = context.resources.getDimensionPixelSize(R.dimen.spacing)
        view.recyclerView?.addItemDecoration(SpacesItemDecoration(spacingInPixels))*/
        view.recyclerView?.adapter = photoAdapter
    }
}
package com.example.photoreference.ui.list

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.photoreference.R
import kotlinx.android.synthetic.main.fragment_list.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {
    private val viewModel: ListViewModel by viewModel()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initPaged(view)
        showImages()
    }

    private fun showImages() {
        viewModel.getImages().observe(this, Observer { list ->
            list?.let {
                photoAdapter.submitList(it)
            }
        })
    }

    private lateinit var photoAdapter: PhotosListAdapter

    private fun initPaged(view: View) {
        photoAdapter = PhotosListAdapter()
        view.recyclerView?.layoutManager = GridLayoutManager(context, 2)
        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing)
        view.recyclerView?.addItemDecoration(SpacesItemDecoration(spacingInPixels))
        view.recyclerView?.adapter = photoAdapter
    }
}

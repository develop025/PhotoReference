package com.example.photoreference.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.photoreference.R
import kotlinx.android.synthetic.main.fragment_list.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {
    private val viewModel: ListViewModel by viewModel()
    private var requestTag:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestTag = arguments?.getString("tag")?:""
    }
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
        viewModel.getImages("tag").observe(this, Observer { list ->
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

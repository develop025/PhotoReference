package com.example.photoreference.ui.menu

import android.graphics.Point
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photoreference.data.menu.Category
import com.example.photoreference.ui.list.PhotosListAdapter
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.main_menu_item.view.*

class MenuHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(
        horizontalListDelegate: HorizontalListDelegate,
        category: Category,
        imageSize: Point,
        menuClickListener: MenuFragment.MenuClickListener
    ) {
        view.setOnClickListener {
            menuClickListener.onClick(category.tag)
        }
        val params = view.horizontalList.layoutParams
        params.height = imageSize.y
        view.itemContainer.layoutParams = params
        view.categoryTitleText.text = category.name

        horizontalListDelegate.init(category.tag, view.horizontalList)

        /*var requestOptions = RequestOptions()
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(16))

        Glide.with(view.menuImage)
            .load(category.icon)
            .apply(requestOptions)
            .into(view.menuImage)

        val country = Locale.getDefault().country
        category.title?.forEach {
            if (it.language?.toLowerCase().equals(country.toLowerCase()))
                view.title.text = it.value
        }*/
        //todo list in list
        /*initPaged(view)
        showImages(listViewModel, category.tag)*/
    }

    /*private fun showImages(viewModel: ListViewModel, requestTag: String) {
        viewModel.getImages(requestTag).observe(this, Observer { list ->
            list?.let {
                photoAdapter.submitList(it)
            }
        })
    }*/

    /*private fun initPaged(view: View) {
        photoAdapter = PhotosListAdapter()
        view.recyclerView?.layoutManager = LinearLayoutManager(view.context)
        *//*val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing)
        view.recyclerView?.addItemDecoration(SpacesItemDecoration(spacingInPixels))*//*
        view.recyclerView?.adapter = photoAdapter
    }*/


}


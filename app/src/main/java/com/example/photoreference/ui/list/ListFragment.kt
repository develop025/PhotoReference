package com.example.photoreference.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photoreference.R
import com.example.photoreference.data.Repo
import com.example.photoreference.data.menu.Category
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.vertical_list_item.view.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {
    //private lateinit var photoAdapter1: PhotosListAdapter
    private val viewModel: ListViewModel by viewModel()
    private val menuViewModel: CategoryViewModel by viewModel()
    private val repo: Repo by inject()
    //private var requestTag: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //requestTag = arguments?.getString("tag") ?: "tag"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        menuViewModel.getMenus().observe(viewLifecycleOwner, Observer { categories ->
            categories?.categories?.let {
                view.recyclerView.layoutManager = LinearLayoutManager(context)
                view.recyclerView.adapter = VerticalListAdapter(it)
            }
        })

        /*  initPaged(view)
          showImages()*/
    }

    inner class VerticalListAdapter(
        val list: List<Category>
    ) : RecyclerView.Adapter<VerticalListItemHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalListItemHolder {
            val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
            return VerticalListItemHolder(view)
        }

        override fun getItemViewType(position: Int): Int {
            return R.layout.vertical_list_item
        }

        override fun getItemCount() = list.size

        override fun onBindViewHolder(holder: VerticalListItemHolder, position: Int) {
            holder.bind(list[position])
        }
    }

    inner class VerticalListItemHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var photoAdapter: PhotosListAdapter

        fun bind(category: Category) {
            initPaged(view)
            showImages(category)
            showTitle(view, category)
            /*  Glide.with(view.menuImage)
                  .load(category.icon)
                  .into(view.menuImage)

              val country = Locale.getDefault().country
              category.title?.forEach {
                  if (it.language?.toLowerCase().equals(country.toLowerCase()))
                      view.title.text = it.value
              }*/
        }

        private fun showImages(category: Category) {
            viewModel.getImages(category.tag).observe(this@ListFragment, Observer { list ->
                list?.let {
                    photoAdapter.submitList(it)
                }
            })
            /*viewModel.getImages(requestTag).observe(this, Observer { list ->
                list?.let {
                    photoAdapter1.submitList(it)
                }
            })*/
        }

        private fun initPaged(view: View) {
            photoAdapter = PhotosListAdapter(repo.imageSize)
            view.horizontalList?.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            val spacingInPixels = resources.getDimensionPixelSize(R.dimen.spacing)
            view.horizontalList?.addItemDecoration(SpacesItemDecoration(spacingInPixels))
            view.horizontalList?.adapter = photoAdapter
            /* photoAdapter1 = PhotosListAdapter()
             view.recyclerView1?.layoutManager = GridLayoutManager(context, 2)
             view.recyclerView1?.addItemDecoration(SpacesItemDecoration(spacingInPixels))
             view.recyclerView1?.adapter = photoAdapter1*/
        }
    }

    private fun showTitle(view: View, category: Category) {
        category.title?.forEach {
            if (it.language == repo.language) {
                view.titleText.text = it.value
                return
            }
            if (it.default) {
                view.titleText.text = it.value
                return
            }
        }
    }
}

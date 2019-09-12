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
import com.example.photoreference.data.repo.CategoriesRepo
import com.example.photoreference.data.db.tables.Category
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.vertical_list_item.view.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment() {
    private val viewModel: ListViewModel by viewModel()
    private val menuViewModel: CategoryViewModel by viewModel()
    private val categoriesRepo: CategoriesRepo by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        menuViewModel.categoryList.observe(viewLifecycleOwner, Observer { categories ->
            view.recyclerView.layoutManager = LinearLayoutManager(context)
            categories.data?.let {
                view.recyclerView.adapter = VerticalListAdapter(it)
            }
        })

        /*  initPaged(view)
          showImages()*/
    }

    inner class VerticalListAdapter(val list: List<Category>) :
        RecyclerView.Adapter<VerticalListItemHolder>() {
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
                  .load(categoryId.icon)
                  .into(view.menuImage)

              val country = Locale.getDefault().country
              categoryId.gitTitle?.forEach {
                  if (it.language?.toLowerCase().equals(country.toLowerCase()))
                      view.gitTitle.text = it.value
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
            photoAdapter = PhotosListAdapter(categoriesRepo.imageSize)
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

        private fun showTitle(view: View, category: Category) {
            //todo
            /*  categoriesRepo.getTitle(category).observe(this@ListFragment, Observer { titles ->
                  if (titles.isNotEmpty())
                      view.titleText.text = titles[0].value
              })*/
        }
    }
}


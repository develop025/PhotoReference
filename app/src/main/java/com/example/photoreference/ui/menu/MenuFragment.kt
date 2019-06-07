package com.example.photoreference.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.photoreference.R
import com.example.photoreference.data.Repo
import com.example.photoreference.data.menu.Category
import com.example.photoreference.ui.list.ListViewModel
import kotlinx.android.synthetic.main.fragment_menu.view.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MenuFragment : Fragment() {
    //private lateinit var horizontalListDelegate: HorizontalListDelegate
    private val viewModel: MenuViewModel by viewModel()
    private val listViewModel: ListViewModel by viewModel()
    private val repo: Repo by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
       // horizontalListDelegate = HorizontalListDelegate(requireContext(), this, listViewModel)

        viewModel.getMenus().observe(viewLifecycleOwner, Observer { categories ->
            categories?.categories?.let { verticalList ->
                view.list.layoutManager = LinearLayoutManager(context)
                view.list.adapter = createVerticalAdapter(verticalList)
            }
        })
        return view
    }

    private fun createVerticalAdapter(verticalList: List<Category>): MenuListAdapter {
        return MenuListAdapter(
            verticalList,
            HorizontalListDelegate(requireContext(), this, listViewModel),
            repo.imageSize,
            object : MenuClickListener {
                override fun onClick(tag: String) {
                    val bundle = bundleOf("tag" to tag)
                    findNavController().navigate(
                        R.id.action_menuFragment_to_listFragment,
                        bundle
                    )
                }
            })
    }

    interface MenuClickListener {
        fun onClick(tag: String)
    }

   /* private fun showImages(viewModel: ListViewModel, requestTag: String) {
        viewModel.getImages(requestTag).observe(this, Observer { list ->
            list?.let {
                photoAdapter.submitList(it)
            }
        })
    }*/
}

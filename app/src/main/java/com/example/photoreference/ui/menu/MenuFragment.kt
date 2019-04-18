package com.example.photoreference.ui.menu

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.photoreference.R
import kotlinx.android.synthetic.main.fragment_menu.view.*
import org.koin.android.viewmodel.ext.android.viewModel

class MenuFragment : Fragment() {
    private val viewModel: MenuViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        viewModel.getMenus().observe(viewLifecycleOwner, Observer { categories ->
            categories?.categories?.let {
                view.list.layoutManager = GridLayoutManager(context, 2)
                view.list.adapter = MenuListAdapter(it)
            }
        })
        return view
    }
}

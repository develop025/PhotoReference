package com.example.photoreference.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.photoreference.R
import kotlinx.android.synthetic.main.fragment_menu.view.*
import org.koin.androidx.viewmodel.ext.android.viewModel

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

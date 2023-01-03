package com.uc.alpvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.uc.alpvp.R
import com.uc.alpvp.adapter.AllListAdapter
import com.uc.alpvp.databinding.ActivityHomepageBinding
import com.uc.alpvp.helper.Const
import com.uc.alpvp.viewModel.ListsViewModel

class homepage : AppCompatActivity() {

    private lateinit var bain: ActivityHomepageBinding
    private lateinit var adapter:AllListAdapter
    private lateinit var viewModel: ListsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bain = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(bain.root)

        viewModel = ViewModelProvider(this).get(ListsViewModel::class.java)
        viewModel.getLists()

        viewModel.lists.observe(this,{ response ->
            bain.rvCardtodo.layoutManager = LinearLayoutManager(this)
            adapter = AllListAdapter(response)
            bain.rvCardtodo.adapter = adapter
        })
    }
}
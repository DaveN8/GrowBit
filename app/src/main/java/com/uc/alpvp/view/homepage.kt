package com.uc.alpvp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.uc.alpvp.R
import com.uc.alpvp.adapter.AllListAdapter
import com.uc.alpvp.databinding.ActivityHomepageBinding
import com.uc.alpvp.helper.Const
import com.uc.alpvp.viewModel.ListsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class homepage : AppCompatActivity() {

    private lateinit var bain: ActivityHomepageBinding
    private lateinit var adapter:AllListAdapter
    private lateinit var viewModel: ListsViewModel

    companion object{
        var user_id = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bain = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(bain.root)

        user_id = intent.getIntExtra("user_id", 0)

        viewModel = ViewModelProvider(this).get(ListsViewModel::class.java)
        viewModel.getListsbyId(user_id)


        viewModel.listsbyid.observe(this, { response ->
            bain.rvCardtodo.layoutManager = LinearLayoutManager(this)
            bain.rvCardtodo.adapter = AllListAdapter(response)
        })

        bain.btnCardtodo.setOnClickListener {
            val intent = Intent(this, inputtodo::class.java)
            intent.putExtra("user_id", user_id)
            startActivity(intent)
        }

        bain.button.setOnClickListener() {
            startActivity(Intent(this, LoginPage::class.java))
            finish()
        }


    }
}
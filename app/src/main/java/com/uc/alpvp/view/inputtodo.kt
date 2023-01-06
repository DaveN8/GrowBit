package com.uc.alpvp.view

import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.uc.alpvp.R
import com.uc.alpvp.databinding.ActivityInputtodoBinding
import com.uc.alpvp.model.Data
import com.uc.alpvp.view.homepage.Companion.user_id
import com.uc.alpvp.viewModel.ListsViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Date

@AndroidEntryPoint
class inputtodo : AppCompatActivity() {

    private lateinit var bain: ActivityInputtodoBinding
    private lateinit var viewModel: ListsViewModel

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bain = ActivityInputtodoBinding.inflate(layoutInflater)
        setContentView(bain.root)

        val listId = intent.getIntExtra("list_id", 0)


        if (listId == 0){
            bain.toolbar.setTitle("Edit Title")
        }else{
            bain.toolbar.setTitle("Add List")
            setupListener()
        }



    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setupListener(){
        createlist()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun createlist(){
        bain.iptSaveButton.setOnClickListener() {
        val li_title = bain.tilTitle.editText!!.text.toString()
        val li_desc = bain.tilDesc.editText!!.text.toString()
        val li_note = bain.tilNote.editText!!.text.toString()

        val set_time = getTime()

        viewModel = ViewModelProvider(this)[ListsViewModel::class.java]

        val date = Date(set_time)
        val date_format = SimpleDateFormat("yyyy-MM-dd")
        val li_date = date_format.format(date)
        val time = SimpleDateFormat("HH:mm")
        val li_time = time.format(set_time)
        val li_u_id = intent.getIntExtra("user_id", 0)

        var iscompeted: Boolean = true

            if (li_title.isEmpty()){
                bain.iptTitle.error = "Title Required"
                iscompeted = false
            }else{
                bain.iptTitle.error = ""
            }


        if (iscompeted) {
            viewModel.deta = viewModel.deta.copy(
                title = li_title,
                description = li_desc,
                note = li_note,
                set_time = li_time,
                set_date = li_date,
                user_id = li_u_id.toString().trim()
            )
            viewModel.createList()
            startActivity(Intent(this, homepage::class.java).putExtra("user_id", li_u_id))
            finish()
        }

        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun getTime(): Long{
        val minute = bain.iptSetTime.minute
        val hour = bain.iptSetTime.hour
        val day = bain.iptSetDate.dayOfMonth
        val month = bain.iptSetDate.month
        val year = bain.iptSetDate.year

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day, hour, minute)
        return calendar.timeInMillis
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun updateList(){
        bain.iptTitle.setText("")
    }


}
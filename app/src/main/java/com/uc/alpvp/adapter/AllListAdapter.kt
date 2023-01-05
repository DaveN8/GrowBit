package com.uc.alpvp.adapter

import android.content.Intent
import android.renderscript.ScriptGroup.Input
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.uc.alpvp.R
import com.uc.alpvp.model.Data
import com.uc.alpvp.view.inputtodo

class AllListAdapter(private val dataSet: ArrayList<Data>) :
            RecyclerView.Adapter<AllListAdapter.ViewHolder>() {

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val tvTitle: TextView
            val tvNote: TextView
            val tvDate: TextView
            val cvList: CardView
//            val btnAdd: Button

            init {
                // Define click listener for the ViewHolder's View.
                tvTitle = view.findViewById(R.id.tv_title_list)
                tvNote = view.findViewById(R.id.tv_note_list)
                tvDate = view.findViewById(R.id.tv_date_list)
                cvList = view.findViewById(R.id.cv_lists)
//                btnAdd = view.findViewById(R.id.btn_cardtodo)

            }
        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                    .inflate(R.layout.card_list_detail, viewGroup, false)

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.tvTitle.text = dataSet[position].title
            viewHolder.tvNote.text = dataSet[position].note
            viewHolder.tvDate.text = dataSet[position].set_date
            viewHolder.cvList.setOnClickListener{
                val intent = Intent(it.context, inputtodo::class.java)
                intent.putExtra("list_id", dataSet[position].id)
                it.context.startActivity(intent)
            }
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = dataSet.size

    }

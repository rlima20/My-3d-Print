package com.example.my3dprint.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.my3dprint.R
import com.example.my3dprint.model.Print

class PrintListAdapter(
    private val context: Context,
    private val prints: MutableList<Print> = mutableListOf(),
    var whenClicked: (print: Print) -> Unit = {}
    ): RecyclerView.Adapter<PrintListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val viewCreated = LayoutInflater.from(context).inflate(
            R.layout.item_print,
            parent,
            false
        )
        return ViewHolder(viewCreated)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val print = prints[position]
        holder.linkTogether(print)
    }

    override fun getItemCount() = prints.size

    fun update(prints: List<Print>){
        notifyItemRangeChanged(0, this.prints.size)
        this.prints.clear()
        this.prints.addAll(prints)
        notifyItemRangeInserted(0, this.prints.size)
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private lateinit var print: Print

        init{
            itemView.setOnClickListener{
                if(::print.isInitialized){
                    whenClicked(print)
                }
            }
        }

        fun linkTogether(print: Print){
            this.print = print
        }
    }
}
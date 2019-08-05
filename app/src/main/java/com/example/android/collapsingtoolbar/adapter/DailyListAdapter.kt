package com.example.android.collapsingtoolbar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.collapsingtoolbar.R
import com.example.android.collapsingtoolbar.data.DailyDataClass
import kotlinx.android.synthetic.main.item_recycler_view.view.*

class DailyListAdapter(private val data: List<DailyDataClass>) : RecyclerView.Adapter<DailyListAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder =
        ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false))

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bindData(data[position])
    }

    inner class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(item: DailyDataClass) {
            itemView.name.text = item.name
            itemView.address.text = item.address
        }
    }
}
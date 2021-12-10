package com.sadly.tugas_final_android.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.phone_specifications_with_api.Spec
import com.sadly.tugas_final_android.R
import kotlinx.android.synthetic.main.item_spec.view.*

class SpecAdapter(private val list : List<Spec>) : RecyclerView.Adapter<SpecAdapter.Holder>() {

    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item : Spec) {
            with(itemView) {
                keyTv.text = item.key + " : "
                valueTv.text = item.`val`.toString().replace("[","").replace("]","")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecAdapter.Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_spec, parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: SpecAdapter.Holder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
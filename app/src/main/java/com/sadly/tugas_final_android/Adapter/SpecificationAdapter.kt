package com.sadly.tugas_final_android.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phone_specifications_with_api.Specification
import com.sadly.tugas_final_android.R
import kotlinx.android.synthetic.main.item_specification.view.*

class SpecificationAdapter(private val listener: SpecificationAdapter.OnItemClickListener) : RecyclerView.Adapter<SpecificationAdapter.Holder>() {

    private var list = mutableListOf<Specification>()

    interface OnItemClickListener {
        fun onClick(att : Specification)
    }

    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Specification, listener: SpecificationAdapter.OnItemClickListener) {
            with(itemView) {
                titleTv.text = item.title
                recySpec.layoutManager = LinearLayoutManager(context)
                recySpec.setHasFixedSize(true)
                recySpec.adapter = SpecAdapter(item.specs)
                shareBtn.setOnClickListener {
                    listener.onClick(item)
                }
            }
        }
    }

    fun setData(list: MutableList<Specification>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecificationAdapter.Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_specification,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: SpecificationAdapter.Holder, position: Int) {
        holder.bind(list[position], listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
package com.sadly.tugas_final_android.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sadly.tugas_final_android.Model.Phone
import com.sadly.tugas_final_android.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list_hp.view.*

class PhoneAdapter(private val listener: PhoneAdapter.Listener): RecyclerView.Adapter<PhoneAdapter.Holder>() {

    interface Listener {
        fun onItemClick(phone: Phone)
    }

    private var listPhone = mutableListOf<Phone>()

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(phone: Phone, listener: Listener) {
            with(itemView) {
                Picasso.get()
                    .load(phone.image)
                    .into(phoneThumb)
                phoneName.text = phone.phone_name
            }
        }
    }

    fun setData(list: MutableList<Phone>) {
        this.listPhone = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_hp, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(listPhone[position], listener)
    }

    override fun getItemCount(): Int {
        return listPhone.size
    }

}
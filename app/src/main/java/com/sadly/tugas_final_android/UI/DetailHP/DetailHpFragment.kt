package com.sadly.tugas_final_android.UI.DetailHP

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sadly.tugas_final_android.Model.Phone
import com.sadly.tugas_final_android.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_hp.*

class DetailHpFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_hp, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailToolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        Picasso.get()
            .load(selectedPhone!!.image)
            .into(detailThumb)

        detailName.text = selectedPhone!!.phone_name

        getSpec()

    }

    private fun getSpec() {
        TODO("Not yet implemented")
    }

    companion object {

        @JvmStatic
        fun newInstance() = DetailHpFragment()
        var selectedPhone: Phone? = null
    }
}
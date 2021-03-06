package com.sadly.tugas_final_android.UI.DetailHP

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phone_specifications_with_api.Specification
import com.sadly.tugas_final_android.Adapter.SpecificationAdapter
import com.sadly.tugas_final_android.Model.Phone
import com.sadly.tugas_final_android.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_hp.*
import kotlinx.coroutines.launch

class DetailHpFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
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
        val adapter = SpecificationAdapter(object : SpecificationAdapter.OnItemClickListener {
            override fun onClick(att: Specification) {
                val title = att.title
                val spec = getSpecValue(att)
                share(title, spec)
            }
        })

        rcView_spesifikasi_hp.setHasFixedSize(true)
        rcView_spesifikasi_hp.layoutManager = LinearLayoutManager(requireContext())
        rcView_spesifikasi_hp.adapter = adapter

        var url = "v2/${selectedPhone!!.slug}"
        lifecycleScope.launch {
            viewModel.getSpecHp(adapter, url)
        }
    }

    private fun getSpecValue(item : Specification) : String {
        var temp = ""
        var list = item.specs
        list.forEach { value ->
            temp += value.key + " : "
            value.`val`.forEach {
                temp += "$it "
            }
            temp += "\n"
        }
        return temp
    }

    private fun share(title : String, spec : String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "BRAND : ${selectedPhone!!.brand}\nPHONE : ${selectedPhone!!.phone_name}\n\n$title\n$spec")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    companion object {

        @JvmStatic
        fun newInstance() = DetailHpFragment()
        var selectedPhone: Phone? = null
    }
}
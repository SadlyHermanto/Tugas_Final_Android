package com.sadly.tugas_final_android.UI.ListHP

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.sadly.tugas_final_android.Adapter.PhoneAdapter
import com.sadly.tugas_final_android.Model.Phone
import com.sadly.tugas_final_android.R
import com.sadly.tugas_final_android.UI.DetailHP.DetailHpFragment
import kotlinx.android.synthetic.main.fragment_list_hp.*
import kotlinx.coroutines.launch


class ListHpFragment : Fragment() {

    private lateinit var adapter: PhoneAdapter
    private lateinit var viewModel: ListHpViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this)[ListHpViewModel::class.java]
        return inflater.inflate(R.layout.fragment_list_hp, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVariable()

        lifecycleScope.launch {
            viewModel.getListPhone(adapter)
        }
    }

    private fun initVariable() {
        adapter = PhoneAdapter(object : PhoneAdapter.Listener {
            override fun onItemClick(phone: Phone) {
                DetailHpFragment.selectedPhone = phone
                findNavController().navigate(R.id.action_listHpFragment_to_detailHpFragment)
            }
        })

        rcView_hp.setHasFixedSize(true)
        rcView_hp.layoutManager = GridLayoutManager(requireContext(), 2)
        rcView_hp.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListHpFragment()
    }
}
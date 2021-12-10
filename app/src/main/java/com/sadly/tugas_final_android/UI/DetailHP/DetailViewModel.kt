package com.sadly.tugas_final_android.UI.DetailHP

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.phone_specifications_with_api.ModelSpec
import com.example.phone_specifications_with_api.Specification
import com.sadly.tugas_final_android.Adapter.SpecificationAdapter
import com.sadly.tugas_final_android.Model.HandPhone
import com.sadly.tugas_final_android.Model.Phone
import com.sadly.tugas_final_android.Network.RetrofitClient
import retrofit2.Response
import java.lang.Exception

class DetailViewModel: ViewModel() {
    private val TAG = "DetailViewModel"

    suspend fun getSpecHp(adapter: SpecificationAdapter, url: String) {
        var response: Response<ModelSpec>? = null
        try {
            response = RetrofitClient.instance.getSpecification(url)
            if(response.isSuccessful) {
                adapter.setData(response!!.body()!!.data.specifications as MutableList<Specification>)
            }
        } catch (e: Exception) {
            Log.e(TAG, "${e.message}")
        }
    }

}
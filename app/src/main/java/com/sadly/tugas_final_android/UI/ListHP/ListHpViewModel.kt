package com.sadly.tugas_final_android.UI.ListHP

import android.util.Log
import androidx.lifecycle.ViewModel
import com.sadly.tugas_final_android.Adapter.PhoneAdapter
import com.sadly.tugas_final_android.Model.HandPhone
import com.sadly.tugas_final_android.Model.Phone
import com.sadly.tugas_final_android.Network.RetrofitClient
import retrofit2.Response
import java.lang.Exception

class ListHpViewModel: ViewModel() {
    private val TAG = "ListHpViewModel"

    suspend fun getListPhone(adapter: PhoneAdapter) {
        var response: Response<HandPhone>? = null
        try {
            response = RetrofitClient.instance.getListHp()
            if(response.isSuccessful) {
                adapter.setData(response!!.body()!!.data.phones as MutableList<Phone>)
            }
        } catch (e: Exception) {
            Log.e(TAG, "${e.message}")
        }

    }

}
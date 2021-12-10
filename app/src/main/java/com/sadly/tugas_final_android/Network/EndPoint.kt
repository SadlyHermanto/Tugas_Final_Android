package com.sadly.tugas_final_android.Network

import com.sadly.tugas_final_android.Model.HandPhone
import retrofit2.Response
import retrofit2.http.GET

interface EndPoint {

    @GET("v2/brands/apple-phones-48")
    suspend fun getListHp(): Response<HandPhone>

}
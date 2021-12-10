package com.sadly.tugas_final_android.Network

import com.example.phone_specifications_with_api.ModelSpec
import com.sadly.tugas_final_android.Model.HandPhone
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface EndPoint {

    @GET("v2/brands/apple-phones-48")
    suspend fun getListHp(): Response<HandPhone>

    @GET
    suspend fun getSpecification(@Url url : String) : Response<ModelSpec>

}
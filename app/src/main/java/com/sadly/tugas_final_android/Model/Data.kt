package com.sadly.tugas_final_android.Model

data class Data(
    val current_page: Int,
    val last_page: Int,
    val phones: List<Phone>,
    val title: String
)
package com.example.phone_specifications_with_api

data class ModelSpec(
    val `data`: Data2,
    val status: Boolean
)

data class Data2(
    val brand: String,
    val created_at: String,
    val phone_img_url: String,
    val phone_name: String,
    val phone_name_slug: String,
    val specifications: List<Specification>
)

data class Specification(
    val specs: List<Spec>,
    val title: String
)

data class Spec(
    val key: String,
    val `val`: List<String>
)
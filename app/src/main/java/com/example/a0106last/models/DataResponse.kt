package com.example.a0106last.models

class DataResponse (
    val user: UserData,
    val token: String,
    val reviews: List<ReviewData>,
    val products: List<ProductData>,
    val review: ReviewData,
        ) {
}
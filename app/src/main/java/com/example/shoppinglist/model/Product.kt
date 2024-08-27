package com.example.shoppinglist.model

data class Product(
    var name: String,
    var brand: String = "",
    var img: String? = null,
) {
}
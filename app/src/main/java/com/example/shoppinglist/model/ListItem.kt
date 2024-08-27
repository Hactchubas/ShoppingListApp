package com.example.shoppinglist.model

import java.math.BigDecimal

data class ListItem(
    val product: Product,
    val quantity: Int,
    val expectedPrice: BigDecimal = BigDecimal(0.0),
    var observations: String? = null
)
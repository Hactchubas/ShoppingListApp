package com.example.shoppinglist.sampledata

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.example.shoppinglist.model.ListItem
import com.example.shoppinglist.model.Product

val sampleSections = mapOf<String, List<ListItem>>(
    "Frios" to listOf(
        ListItem(
            Product(
                name = "Queijo",
                brand = "Coalho",
                img = "https://carrefourbrfood.vtexassets.com/arquivos/ids/42654459/queijo-coalho-barra-carrefour-classic-460-g-1.jpg?v=637842726673130000"
            ),
            quantity = 200,
            observations = LoremIpsum(50).values.first()
        ),
        ListItem(
            Product(
                name = "Presunto",
                brand = "Peito de Peru",
                img = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQK8X2V39qJlaV0UbpzTC4rapQ07FqvL8TaLw&s"
            ),
            quantity = 100
        ),
        ListItem(
            Product(
                name = "Refri",
                brand = "Pepsi 2L",
                img = "https://destro.fbitsstatic.net/img/p/refrigerante-pepsi-cola-pet-2l-78447/265002-1.jpg?w=500&h=500&v=no-change&qs=ignore"
            ),
            quantity = 5,
            observations = LoremIpsum(50).values.first()
        ),
        ListItem(
            Product(
                name = "Hamburguer",
                brand = "Texas Burguer",
                img = "https://supermercadobomdemais.com.br/wp-content/uploads/2020/06/201382_hamburguer.jpg"
            ),
            quantity = 1,
            observations = LoremIpsum(50).values.first()
        )
    ),
    "Fazer Brigadeiro" to listOf(
        ListItem(
            Product(
                name = "Achocolatado",
                brand = "do Padre",
                img = "https://io.convertiez.com.br/m/superpaguemenos/shop/products/images/15765/medium/chocolate-em-po-nestle-50-cacau-dois-frades-200g_17517.png"
            ),
            quantity = 1
        ),
        ListItem(
            Product(
                name = "Leite Condensado",
                brand = "Moça",
                img = "https://hiperideal.vtexassets.com/arquivos/ids/215215-800-450?v=638320409410570000&width=800&height=450&aspect=true"
            ),
            quantity = 2
        ),
    ),
    "Quebra Galho" to listOf(
        ListItem(
            Product(
                name = "Rappi",
                brand = "Fit",
                img = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSoT3Ivq9c6G0bLmz79nMs_HxH6_sm3_oSgAg&s"
            ),
            quantity = 1
        ),
        ListItem(
            Product(
                name = "Pão de hamburguer",
                img = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7T6ndelQy4XVN2kZq7wc-TWdOC7XHDV3jSA&s"
            ),
            quantity = 1,
            observations = LoremIpsum(50).values.first()
        ),
    )

)
package com.example.shoppinglist.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.shoppinglist.R
import com.example.shoppinglist.extensions.toBrazilianCurrency
import com.example.shoppinglist.model.ListItem
import com.example.shoppinglist.model.Product
import com.example.shoppinglist.sampledata.itemsSamples
import com.example.shoppinglist.sampledata.sampleItem
import com.example.shoppinglist.sampledata.sampleProduct
import com.example.shoppinglist.ui.theme.MyBlack
import com.example.shoppinglist.ui.theme.MyYellow

@Composable
fun ItemCard(
    item: ListItem = sampleItem
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            AsyncImage(
                model = item.product.img,
                contentDescription = null,
                Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(MyYellow),
                placeholder = painterResource(id = R.drawable.list_item_placeholder),
                contentScale = ContentScale.Crop
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(MyBlack)
                    .padding(16.dp)
            ) {
                Text(
                    text = item.product.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(700),
                    color = MyYellow
                )
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .  fillMaxWidth()
                ){
                    Text(
                        text = "Quantity: ${item.quantity}"
                    )
                    Text(
                        text = "Unit price: ${item.expectedPrice.toBrazilianCurrency()}"
                    )
                }
            }
            item.observations?.let {
                Text(
                    text = it,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemCardPreview() {
    Surface {
        ItemCard(
            item = sampleItem
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ItemCardPreviewWithDescription() {
    Surface {
        ItemCard(
            item = sampleItem.apply {
                observations = LoremIpsum(50).values.first()
            }
        )
    }
}
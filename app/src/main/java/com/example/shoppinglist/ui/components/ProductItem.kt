package com.example.shoppinglist.ui.components

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.shoppinglist.R
import com.example.shoppinglist.extensions.toBrazilianCurrency
import com.example.shoppinglist.model.ListItem
import com.example.shoppinglist.model.Product
import com.example.shoppinglist.sampledata.sampleItem
import com.example.shoppinglist.ui.theme.MyRed
import com.example.shoppinglist.ui.theme.MyYellow
import com.example.shoppinglist.ui.theme.ShoppingListTheme
import java.math.BigDecimal

@Composable
fun ProductItem(
    item: ListItem = sampleItem,
) {
    Surface(
        shape = RoundedCornerShape(15),
        shadowElevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            var expanded by remember {
                mutableStateOf(false)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clickable {
                        expanded = !expanded
                        Log.v("HomeScreen", expanded.toString())
                    }
            ) {
                AsyncImage(
                    model = item.product.img,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .background(MyYellow)
                        .widthIn(max = 70.dp)
                        .fillMaxHeight()
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = "${item.product.name} - ${item.product.brand}",
                        fontWeight = FontWeight(700),
                        fontSize = 16.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = item.expectedPrice.toBrazilianCurrency(),
                            fontSize = 14.sp
                        )
                        Text(
                            text = "Qntd.: ${item.quantity}",
                            fontSize = 14.sp,
                        )
                    }
                }
            }
            AnimatedVisibility(visible = expanded) {
                item.observations?.let {
                    Text(
                        text = it,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(16.dp)
                            .height(100.dp)
                    )
                }
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    ShoppingListTheme {
        ProductItem()
    }
}

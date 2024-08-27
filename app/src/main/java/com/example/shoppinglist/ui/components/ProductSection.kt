package com.example.shoppinglist.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppinglist.sampledata.itemsSamples
import com.example.shoppinglist.model.ListItem
import com.example.shoppinglist.ui.theme.MyYellow
import com.example.shoppinglist.ui.theme.ShoppingListTheme

@Composable
fun ProductSection(
    title: String = "Title",
    itemsList: List<ListItem> = itemsSamples
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight(700),
            color = MyYellow,
            modifier = Modifier
                .padding(vertical = 5.dp)
        )
        Column (
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            for(item in itemsList){
                ProductItem(
                    item = item
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductSectionPreview() {
    ShoppingListTheme {
        ProductSection()
    }
}


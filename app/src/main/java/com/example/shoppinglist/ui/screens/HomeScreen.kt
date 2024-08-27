package com.example.shoppinglist.ui.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shoppinglist.model.ListItem
import com.example.shoppinglist.sampledata.itemsSamples
import com.example.shoppinglist.sampledata.sampleSections
import com.example.shoppinglist.ui.components.ItemCard
import com.example.shoppinglist.ui.components.ProductSection
import com.example.shoppinglist.ui.theme.MyBlack
import com.example.shoppinglist.ui.theme.ShoppingListTheme

@Composable
fun HomeScreen(
    sectionsList: Map<String, List<ListItem>> = sampleSections
) {
    ShoppingListTheme {
        Column(
            Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            var searchText by remember {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                },
                shape = RoundedCornerShape(50),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search , contentDescription = null)
                },
                label = {
                    Text(text = "Product")
                },
                placeholder = {
                    Text(text = "What are you looking for?")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
            )

            if (searchText.isNotEmpty()) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(vertical = 16.dp),
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(itemsSamples) {
                        ItemCard(it)
                    }
                }
            }
            else{
                Column (
                    Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ){
                    for (section in sectionsList) {
                        ProductSection(
                            title = section.key,
                            itemsList = section.value
                        )
                    }
                }

            }

        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    ShoppingListTheme {
        Surface(
            color = MyBlack
        ) {
        HomeScreen()
        }
    }
}



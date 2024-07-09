package com.example.foodordering.ui.screen.customer.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.foodordering.ui.component.TopAppBarHome
import com.example.foodordering.ui.screen.customer.component.Categories
import com.example.foodordering.ui.screen.customer.component.FoodRecyclerView
import com.example.foodordering.ui.theme.DarkColorScheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onSearch: (String) -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .background(
                    color = DarkColorScheme.primary
                )
                .fillMaxWidth()
                .padding(20.dp)
                .height(180.dp)
        ) {
            TopAppBarHome()

            var searchValue by remember {
                mutableStateOf("")
            }

            SearchBar(
                modifier = Modifier.padding(top = 20.dp),
                placeholder = { Text(text = "Search ...") },
                query = searchValue,
                onQueryChange = { searchValue = it },
                onSearch = { onSearch(it) },
                active = false,
                onActiveChange = {}
            ) {

            }

        }

        Column(
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {


            Text(
                modifier = Modifier.padding(top = 20.dp),
                text = "Categories",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Categories(Modifier.padding(top = 10.dp))

            Text(
                modifier = Modifier.padding(top = 20.dp),
                text = "Offer & Deal \uD83D\uDE04",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            FoodRecyclerView()

            Button(onClick = {
                viewModel.getCart()
            }) {
                Text(text = "Add Cart")
            }

        }

    }
}


@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen({})
}



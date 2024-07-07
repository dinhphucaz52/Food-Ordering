package com.example.foodordering.ui.screen.customer.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodordering.R
import com.example.foodordering.ui.theme.DarkColorScheme

@Composable
fun FoodRecyclerView(
    popularImagesList: List<Int> = listOf<Int>(
        R.drawable.burger,
        R.drawable.burger2,
        R.drawable.burger,
        R.drawable.burger2,
        R.drawable.burger,
        R.drawable.burger2,
        R.drawable.burger,
        R.drawable.burger2,
    ),
    popularTitleNameList: List<String> = listOf(
        "Chicken Burger", "Beef Burger",
        "Chicken Burger", "Beef Burger",
        "Chicken Burger", "Beef Burger",
        "Chicken Burger", "Beef Burger",
        "Chicken Burger", "Beef Burger",
    ),
    popularSubTitleItemList: List<String> = listOf(
        "Burger King", "Shake Shack",
        "Burger King", "Shake Shack",
        "Burger King", "Shake Shack",
        "Burger King", "Shake Shack",
        "Burger King", "Shake Shack",
    ),
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(popularImagesList.size) { item ->
            Column(
                modifier = Modifier
                    .width(200.dp)
                    .wrapContentHeight()
                    .padding(vertical = 10.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .border(
                        width = 2.dp, color = DarkColorScheme.primary
                    )
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.size(100.dp),
                    painter = painterResource(popularImagesList[item]),
                    contentDescription = "",
                    contentScale = ContentScale.Fit
                )

                Text(
                    text = popularTitleNameList[item],
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )

                Text(
                    text = popularSubTitleItemList[item],
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "100.000 VNĐ",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkColorScheme.primary
                    )

                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(DarkColorScheme.primary)
                            .padding(4.dp)
                            .clickable { }, contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            modifier = Modifier.size(20.dp, 20.dp),
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add",
                            tint = Color.White
                        )
                    }

                }
            }
        }
    }

}

@Preview
@Composable
fun FoodRecyclerViewPreview() {
    FoodRecyclerView()
}
package com.jeremy.mikie.ui.screens.order



import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jeremy.mikie.navigation.ROUT_HOME
import com.jeremy.mikie.R
import com.jeremy.mikie.model.FoodItem
import com.jeremy.mikie.model.OrderViewModel
import com.jeremy.mikie.navigation.ROUT_ADMIN_ORDERS
import com.jeremy.mikie.navigation.ROUT_ORDER
import com.jeremy.mikie.navigation.ROUT_SAVED


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OderScreen(orderViewModel: OrderViewModel, navController: NavController) {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("What do you want to eat today?..") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Red,
                    titleContentColor = Color.White
                )
            )
        },

        bottomBar = {
            NavigationBar(containerColor = Color.Red) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Search") },
                    label = { Text("Order") },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_ORDER)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Search") },
                    label = { Text("Saved Orders") },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_SAVED)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Search") },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )




            }
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Add action */ },
                containerColor = Color.LightGray
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },

        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                Text("Choose Food to Order", fontSize = 22.sp, color = Color.Red)
                Spacer(modifier = Modifier.height(10.dp))

                val foodItems = listOf(
                    FoodItem("Smocha", "SH:90", R.drawable.smocha),
                    FoodItem("Smocha Mayai", "SH:120", R.drawable.smocha),
                    FoodItem("Smokie", "SH:50", R.drawable.smokie),
                    FoodItem("Hot Dog", "SH:80", R.drawable.hotdog),
                    FoodItem("Mayai", "SH:40", R.drawable.mayai),
                    FoodItem("Samosa Nyama", "SH:60", R.drawable.samosa),
                    FoodItem("Smocha Viazi", "SH:40", R.drawable.samosa),
                    FoodItem("Smocha Dengu", "SH:40", R.drawable.samosa)
                )

                foodItems.forEach { item ->
                    FoodItemCard(
                        item = item,
                        onSelect = { orderViewModel.addItem(it) },
                        navController = navController
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = {
                    navController.navigate(ROUT_SAVED)
                }) {
                    Text("View Saved Orders")
                }
            }
        }
    )
}

// ✅ Moved Outside
@Composable
fun FoodItemCard(
    item: FoodItem,
    onSelect: (FoodItem) -> Unit,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = item.name,
                    modifier = Modifier.size(60.dp)
                )
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(text = item.name, fontSize = 18.sp, color = Color.Red)
                    Text(text = item.price, fontSize = 14.sp)
                }
            }

            Button(onClick = {
                onSelect(item)
                navController.navigate(ROUT_ADMIN_ORDERS)
            }) {
                Text("Add")
            }
        }
    }
}

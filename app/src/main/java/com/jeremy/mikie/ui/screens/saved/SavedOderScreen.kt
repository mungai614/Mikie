package com.jeremy.mikie.ui.screens.saved

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jeremy.mikie.model.OrderViewModel


@Composable
fun SavedOrdersScreen(orderViewModel: OrderViewModel, navController: NavController) {
    val selectedItems by orderViewModel.selectedItems.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Your Saved Orders", fontSize = 22.sp, color = Color.Red)
        Spacer(modifier = Modifier.height(10.dp))

        if (selectedItems.isEmpty()) {
            Text("No items ordered yet.")
        } else {
            selectedItems.forEach { item ->
                Text("- ${item.name} (${item.price})", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { orderViewModel.clearOrder() }) {
                Text("Clear Orders")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            navController.navigate("order")
        }) {
            Text("Back to Order")
        }
    }
}

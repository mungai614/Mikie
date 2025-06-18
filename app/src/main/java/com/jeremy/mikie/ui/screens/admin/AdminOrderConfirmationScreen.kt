package com.jeremy.mikie.ui.screens.admin

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jeremy.mikie.navigation.ROUT_LOGIN
import com.jeremy.mikie.navigation.ROUT_ORDER
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminOrderConfirmationScreen(navController: NavController) {
    val coroutine = rememberCoroutineScope()
    coroutine.launch {
        delay(1000)
        navController.navigate(ROUT_ORDER)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Order Confirmation") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Red)
            )
        },
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Order has been successfully made!",
                    fontSize = 24.sp,
                    color = Color.Green
                )
            }
        }
    )
}

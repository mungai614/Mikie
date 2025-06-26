package com.jeremy.mikie.ui.screens.assist

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jeremy.mikie.navigation.ROUT_HOME
import com.jeremy.mikie.ui.theme.neworange
import com.jeremy.mikie.ui.theme.newwhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AssistScreen(navController: NavController) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Support Options", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = neworange,
                    titleContentColor = newwhite,
                    navigationIconContentColor = newwhite,
                    actionIconContentColor = newwhite,
                ),
                navigationIcon = {
                    IconButton(onClick = {navController.navigate(ROUT_HOME) }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },

            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("Choose a support action:", fontSize = 18.sp, fontWeight = FontWeight.Medium)

            // Call
            Button(
                onClick = {
                    val callIntent = Intent(Intent.ACTION_DIAL).apply {
                        data = "tel:0720597285".toUri()
                    }
                    try {
                        context.startActivity(callIntent)
                    } catch (e: Exception) {
                        Toast.makeText(context, "No app available to handle calls", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE53935))
            ) {
                Icon(Icons.Default.Call, contentDescription = "Call", modifier = Modifier.padding(end = 8.dp))
                Text("Call Support")
            }

            // Email
            Button(
                onClick = {
                    val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                        data = "mailto:mungajeremia816@gmail.com".toUri()
                        putExtra(Intent.EXTRA_SUBJECT, "Subject")
                        putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                    }
                    try {
                        context.startActivity(emailIntent)
                    } catch (e: Exception) {
                        Toast.makeText(context, "No email app installed", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E88E5))
            ) {
                Icon(Icons.Default.Email, contentDescription = "Email", modifier = Modifier.padding(end = 8.dp))
                Text("Send Email")
            }

            // SMS
            Button(
                onClick = {
                    val smsIntent = Intent(Intent.ACTION_SENDTO).apply {
                        data = "smsto:0720597285".toUri()
                        putExtra("sms_body", "Hello Jeremy...")
                    }
                    try {
                        context.startActivity(smsIntent)
                    } catch (e: Exception) {
                        Toast.makeText(context, "No messaging app installed", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF43A047))
            ) {
                Icon(Icons.Default.Edit, contentDescription = "SMS", modifier = Modifier.padding(end = 8.dp))
                Text("Send SMS")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AssistScreenPreview() {
    AssistScreen(navController = rememberNavController())
}

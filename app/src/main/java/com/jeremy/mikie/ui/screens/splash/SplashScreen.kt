package com.jeremy.mikie.ui.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jeremy.mikie.R
import com.jeremy.mikie.navigation.ROUT_HOME
import com.jeremy.mikie.navigation.ROUT_LOGIN
import com.jeremy.mikie.navigation.ROUT_REGISTER
import com.jeremy.mikie.ui.theme.Green
import com.jeremy.mikie.ui.theme.Orange
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController) {
    //Navigation
    val coroutine = rememberCoroutineScope()
    coroutine.launch {
        delay(2000)
        navController.navigate(ROUT_LOGIN)
    }
    //end of navigate

    Column(
        modifier =  Modifier.fillMaxSize().background(color = Orange),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "WELCOME",
            fontSize = 30.sp,
            color = Green

        )
        Text(
            text = "Choose your Dish",
            fontSize = 20.sp,
            color = Green
        )

        Image(
            painter = painterResource(R.drawable.sandwich),
            contentDescription = "home",
            modifier = Modifier.fillMaxSize()
        )
        Spacer(modifier = Modifier.height(10.dp))



    }

}
@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())

}


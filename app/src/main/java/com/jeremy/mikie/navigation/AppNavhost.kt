package com.jeremy.mikie.navigation

import OrderConfirmationScreen
import SaveOrderScreen2
import SavedOrdersScreen3
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jeremy.mikie.data.UserDatabase
import com.jeremy.mikie.model.OrderViewModel
import com.jeremy.mikie.model.User
import com.jeremy.mikie.register.LoginScreen
import com.jeremy.mikie.register.RegisterScreen
import com.jeremy.mikie.repository.UserRepository
import com.jeremy.mikie.ui.screens.about.AboutScreen
import com.jeremy.mikie.ui.screens.admin.AdminOrderConfirmationScreen



import com.jeremy.mikie.ui.screens.home.HomeScreen
import com.jeremy.mikie.ui.screens.order.OrderScreen


import com.jeremy.mikie.ui.screens.saved.SavedOrdersScreen

import com.jeremy.mikie.ui.screens.splash.SplashScreen
import com.jeremy.mikie.viewmodel.AuthViewModel
import com.jeremy.mikie.viewmodel.OrderViewModel2


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH
) {
    val context = LocalContext.current
    val orderViewModel: OrderViewModel = viewModel()
    val orderViewModel2: OrderViewModel2 = viewModel()



    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_ORDER) {
            OrderScreen(orderViewModel2 = orderViewModel2, navController = navController)
        }

        composable(ROUT_SAVED) {
            SavedOrdersScreen(orderViewModel2 = orderViewModel2, navController = navController)
        }

        composable(ROUT_HOME) {
            HomeScreen(navController = navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController = navController)
        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController = navController)
        }
        composable(ROUT_ADMIN_ORDERS) {
            AdminOrderConfirmationScreen(navController)
        }
        composable(ROUT_ORDER_CONFIRMATION) {
            OrderConfirmationScreen(orderViewModel = orderViewModel, navController = navController)
        }
        composable(ROUT_SAVED_ORDERS) {
            SaveOrderScreen2(
                orderViewModel = OrderViewModel(),
                navController = navController
            )
        }
        composable(ROUT_SAVED_ORDER3) {
            SavedOrdersScreen3(orderViewModel = orderViewModel, navController = navController)
        }










        // Initialize Room Database and Repository for Authentication
        val appDatabase = UserDatabase.getDatabase(context)
        val authRepository = UserRepository(appDatabase.userDao())
        val authViewModel: AuthViewModel = AuthViewModel(authRepository)
        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }

        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_HOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }







    }
}

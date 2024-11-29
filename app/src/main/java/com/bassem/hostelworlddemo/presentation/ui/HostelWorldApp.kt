package com.bassem.hostelworlddemo.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bassem.hostelworlddemo.presentation.ui.details.DetailsScreen
import com.bassem.hostelworlddemo.presentation.ui.home.HomeScreen

@Composable
fun HostelWorldApp() {
    val navController = rememberNavController()
    CatsNavHost(navController)

}

@Composable
fun CatsNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(onClick = {
            }, navController = navHostController)
        }
        composable(route = Screen.Details.route, arguments = Screen.Details.navArguments) {
        }

    }
}

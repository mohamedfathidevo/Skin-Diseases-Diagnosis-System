package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.splash_screen.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SplashScreen(
    navController: NavController
) {

}

@Preview(showBackground = true)
@Composable
fun SplashScreenPrev() {
    val navController = rememberNavController()
    SplashScreen(
        navController = navController
    )
}
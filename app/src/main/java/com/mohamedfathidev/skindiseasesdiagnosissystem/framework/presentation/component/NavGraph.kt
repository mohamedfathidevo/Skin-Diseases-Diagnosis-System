package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.component

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.about_screen.component.AboutScreen
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.main_screen.component.MainScreen
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.option_screen.component.OptionScreen
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.result_screen.component.ResultScreen
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.splash_screen.component.SplashScreen

@Composable
fun SetupNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Splash.route
    ) {

        composable(
            route = Screen.Splash.route
        ) {
            SplashScreen(navController = navHostController)
        }

        composable(
            route = Screen.Main.route
        ) {
            MainScreen(navController = navHostController)
        }

        composable(
            route = Screen.Option.route
        ) {
            OptionScreen(navController = navHostController)
        }

        composable(
            route = Screen.Result.route + "/{uri}",
            arguments = listOf(
                navArgument(
                    name = "uri"
                ) {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) { entry ->
            entry.arguments?.getString("uri")?.let {
                ResultScreen(
                    navController = navHostController,
                    uri = it
                )
            }
        }

        composable(
            route = Screen.About.route
        ) {
            AboutScreen(
                navController = navHostController
            )
        }
    }
}
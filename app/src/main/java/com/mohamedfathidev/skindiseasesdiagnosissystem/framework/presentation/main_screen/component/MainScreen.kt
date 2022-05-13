package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.main_screen.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.component.Screen

@Composable
fun MainScreen(
    navController: NavController
) {
    MainScreenItems(
        navController = navController ,
        onClickContinueButton = { navController.navigate(Screen.Option.route) },
        onClickAboutButton = { navController.navigate(Screen.About.route) }
    )
}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    MainScreen(
        navController = navController
    )
}
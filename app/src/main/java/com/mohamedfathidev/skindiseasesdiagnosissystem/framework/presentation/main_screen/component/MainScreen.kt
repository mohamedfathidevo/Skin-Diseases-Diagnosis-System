package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.main_screen.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(
    navController: NavController
) {

}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    MainScreen(
        navController = navController
    )
}
package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.about_screen.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AboutScreen(
    navController: NavController
) {
    AboutScreenItems(
        navController = navController,
        onNavigateButton = {
            navController.popBackStack()
        }
    )
}


@Preview
@Composable
fun AboutScreenPreview() {
    val navController = rememberNavController()
    AboutScreen(navController = navController)
}

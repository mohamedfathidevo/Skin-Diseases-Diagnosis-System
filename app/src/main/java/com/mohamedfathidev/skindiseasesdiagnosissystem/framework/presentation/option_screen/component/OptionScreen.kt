package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.option_screen.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun OptionScreen(
    navController: NavController
) {

}

@Preview(showBackground = true)
@Composable
fun OptionScreenPreview() {
    val navController = rememberNavController()
    OptionScreen(navController = navController)
}
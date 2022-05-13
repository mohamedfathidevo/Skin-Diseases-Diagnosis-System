package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.component

sealed class Screen(val route: String) {
    object Splash: Screen(route = "splash_screen")
    object Main: Screen(route = "main_screen")
    object Option: Screen(route = "option_screen")
    object Result: Screen(route = "result_screen")
    object About: Screen(route = "about_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
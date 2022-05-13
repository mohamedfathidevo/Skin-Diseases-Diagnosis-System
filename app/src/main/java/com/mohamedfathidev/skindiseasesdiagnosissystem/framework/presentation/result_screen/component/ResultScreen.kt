package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.result_screen.component

import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.util.Constant.TAG
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.component.Screen
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.result_screen.viewmodel.ResultViewModelImpl
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.util.createPart

@Composable
fun ResultScreen(
    navController: NavController,
    uri: String,
    viewModel: ResultViewModelImpl = hiltViewModel()
) {
    val context = LocalContext.current
    val stateNetwork = viewModel.state.value

    LaunchedEffect(true){
        Log.d(TAG, "ResultScreen: $uri")
        val part = createPart(context, Uri.parse(uri))
        viewModel.getDiseasesResult(part)
    }

    ResultScreenItems(
        navController = navController,
        diseases = stateNetwork.diseases,
        isLoading = stateNetwork.isLoading
    )

    if (stateNetwork.error.isNotBlank()) {
        Toast.makeText(context, "Error Happen", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "ResultScreen Error happen: ${stateNetwork.error}")
        navController.navigate(Screen.Option.route) {
            popUpTo(Screen.Result.route) {
                inclusive = true
            }
        }
    }
}
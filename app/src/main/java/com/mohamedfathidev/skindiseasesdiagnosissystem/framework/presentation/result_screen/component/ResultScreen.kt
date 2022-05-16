package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.result_screen.component

import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
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

    if (uri.isNotEmpty()){
        LaunchedEffect(true){
            Log.d(TAG, "ResultScreen: $uri")
            val part = createPart(context, Uri.parse(uri))
            viewModel.getDiseasesResult(part)
        }
    } else {
        Toast.makeText(context, "Error Happen", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "ResultScreen Error happen: ${stateNetwork.error}")
        navController.popBackStack()
    }
    ResultScreenItems(
        navController = navController,
        diseases = stateNetwork.diseases,
        isLoading = stateNetwork.isLoading,
        error = stateNetwork.error
    )
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPrev() {
    val navController = rememberNavController()
    ResultScreen(
        navController = navController,
        uri = ""
    )
}
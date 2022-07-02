package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.result_screen.component

import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.util.Constant.TAG
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.component.Screen
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.result_screen.viewmodel.ResultViewModelImpl
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.util.createPart
import kotlinx.coroutines.delay

@Composable
fun ResultScreen(
    navController: NavController,
    uri: String,
    viewModel: ResultViewModelImpl = hiltViewModel()
) {
    var isLoading = remember { mutableStateOf(true) }
    val context = LocalContext.current
    val stateNetwork = viewModel.state.value

    //Edit Just for discussion
    if (uri.isNotEmpty()){
//        LaunchedEffect(true){
//            Log.d(TAG, "ResultScreen: $uri")
//            val part = createPart(context, Uri.parse(uri))
//            viewModel.getDiseasesResult(part)
//        }
        LaunchedEffect(true){
            if (uri == "gallery"){
                viewModel.justForTest(2)
            }else{
                viewModel.justForTest(1)
            }
        }
        if(uri == "gallery"){
            ResultScreenItems(
                navController = navController,
                diseases = stateNetwork.diseases,
                isLoading = stateNetwork.isLoading,
                error = stateNetwork.error
            )
        }else{
            SafeDiagnosis(isLoading.value)
            LaunchedEffect(true){
                delay(5000)
                isLoading.value = !isLoading.value
            }
        }
    } else {
        Toast.makeText(context, "Error Happen", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "ResultScreen Error happen: ${stateNetwork.error}")
        navController.popBackStack()
    }
//    ResultScreenItems(
//        navController = navController,
//        diseases = stateNetwork.diseases,
//        isLoading = stateNetwork.isLoading,
//        error = stateNetwork.error
//    )
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
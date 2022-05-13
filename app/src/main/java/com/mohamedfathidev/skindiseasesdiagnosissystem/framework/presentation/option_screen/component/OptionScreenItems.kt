package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.option_screen.component

import android.Manifest
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.canhub.cropper.CropImageContract
import com.canhub.cropper.CropImageContractOptions
import com.canhub.cropper.CropImageOptions
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.mohamedfathidev.skindiseasesdiagnosissystem.R
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.util.Constant.TAG
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.component.Screen
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.util.ConnectivityStatus
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.util.getTmpFileUri
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@OptIn(
    ExperimentalPermissionsApi::class, ExperimentalAnimationApi::class,
    ExperimentalCoroutinesApi::class
)
@Composable
fun OptionScreenItems(
    navController: NavController
) {
    val context = LocalContext.current
    val multiplePermissionsState = rememberMultiplePermissionsState(
        listOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
        )
    )
    var imageCameraUri by remember {
        mutableStateOf<Uri?>(getTmpFileUri(context = context))
    }
    var imageGalleryUri by remember {
        mutableStateOf<Uri?>(null)
    }

    var imageCropCameraLauncher = rememberLauncherForActivityResult(CropImageContract()) { result ->
        if (result.isSuccessful) {
            imageCameraUri = result.uriContent
            val encodedCameraUrl = URLEncoder.encode(imageCameraUri.toString(), StandardCharsets.UTF_8.toString())
            navController.navigate(Screen.Result.withArgs(encodedCameraUrl))
        } else{
            Log.d(TAG, "OptionCropCameraImage: ${result.error.toString()}")
        }
    }

    var imageCropGalleryLauncher = rememberLauncherForActivityResult(CropImageContract()) { result ->
        if (result.isSuccessful) {
            imageGalleryUri = result.uriContent
            val encodedGalleryUrl = URLEncoder.encode(imageGalleryUri.toString(), StandardCharsets.UTF_8.toString())
            navController.navigate(Screen.Result.withArgs(encodedGalleryUrl))
        } else{
            Log.d(TAG, "OptionCropGalleryImage: ${result.error.toString()}")
        }
    }

    val launcherCamera = rememberLauncherForActivityResult(
        contract =
        ActivityResultContracts.TakePicture()
    ) { isSuccess ->
        if (isSuccess) {
            val cropOptions = CropImageContractOptions(imageCameraUri, CropImageOptions())
            imageCropCameraLauncher.launch(cropOptions)
        } else {
            Log.d(TAG, "Failed to access permissions")
        }
    }

    val launcherImage = rememberLauncherForActivityResult(
        contract =
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        val cropOptions = CropImageContractOptions(imageGalleryUri, CropImageOptions())
        imageCropGalleryLauncher.launch(cropOptions)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = {
                    if (checkPermissions(multiplePermissionsState)) {
                        Log.d(TAG, "accepted all permissions")
                        launcherCamera.launch(imageCameraUri)
                    } else {
                        Log.d(TAG, "there are problem in permissions")
                        multiplePermissionsState.launchMultiplePermissionRequest()
                    }
                },
                modifier = Modifier
                    .padding(4.dp)
                    .size(180.dp)
                    .align(Alignment.CenterHorizontally),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.Black
                ),
                shape = CircleShape
            ) {
                Icon(
                    painter = painterResource(R.drawable.camera),
                    contentDescription = "camera",
                    modifier = Modifier.size(100.dp),
                    tint = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            OutlinedButton(
                onClick = {
                    if (checkPermissions(multiplePermissionsState)) {
                        Log.d(TAG, "accepted all permissions")
                        launcherImage.launch("image/*")
                    } else {
                        Log.d(TAG, "there are problem in permissions")
                        multiplePermissionsState.launchMultiplePermissionRequest()
                    }
                },
                modifier = Modifier
                    .padding(4.dp)
                    .size(180.dp)
                    .align(Alignment.CenterHorizontally),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.Black
                ),
                shape = CircleShape
            ) {
                Icon(
                    painter = painterResource(R.drawable.gallery),
                    contentDescription = "gallery",
                    modifier = Modifier.size(100.dp),
                    tint = Color.Black
                )
            }
        }
    }

    ConnectivityStatus(navController = navController)
}

@OptIn(ExperimentalPermissionsApi::class)
fun checkPermissions(multiplePermissionsState: MultiplePermissionsState): Boolean {
    return multiplePermissionsState.allPermissionsGranted
}
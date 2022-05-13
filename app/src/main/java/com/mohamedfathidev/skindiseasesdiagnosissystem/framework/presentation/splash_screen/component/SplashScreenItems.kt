package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.splash_screen.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mohamedfathidev.skindiseasesdiagnosissystem.R
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.ui.theme.buttonColor
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.util.ConnectivityStatus
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalAnimationApi::class, ExperimentalCoroutinesApi::class)
@Composable
fun SplashScreenItems(
    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(150.dp)
                    .height(200.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(
                modifier = Modifier.height(10.dp)
            )
            CircularProgressIndicator(
                color = buttonColor
            )
        }

        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Copyright 2022 @ Skiner Team",
                modifier = Modifier
                    .padding(bottom = 15.dp),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.berkshire_swash_new)),
                    fontSize = 20.sp
                )
            )
        }

        ConnectivityStatus(
            navController = navController,
            isSplashScreen = true
        )

    }
}
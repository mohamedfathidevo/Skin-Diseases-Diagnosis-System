package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.about_screen.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mohamedfathidev.skindiseasesdiagnosissystem.R
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.util.ConnectivityStatus
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.util.DefaultAppBar
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalAnimationApi::class, ExperimentalCoroutinesApi::class)
@Composable
fun AboutScreenItems(
    navController: NavController,
    onNavigateButton: () -> Unit
) {
    Scaffold(
        topBar = {
            DefaultAppBar(
                onNavigateButton = onNavigateButton
            )
        }
    ) {
        AboutContent()
        ConnectivityStatus(navController = navController)
    }
}

@Composable
fun AboutContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier
                .padding(16.dp),
            text = stringResource(R.string.advice),
            style = TextStyle(
                fontSize = 15.sp,
                color = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            text = stringResource(R.string.list),
            style = TextStyle(
                fontSize = 15.sp,
                color = Color.Black
            ),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            text = stringResource(R.string.diseases_list),
            style = TextStyle(
                fontSize = 15.sp,
                color = Color.Black
            ),
            textAlign = TextAlign.Center
        )
    }
}
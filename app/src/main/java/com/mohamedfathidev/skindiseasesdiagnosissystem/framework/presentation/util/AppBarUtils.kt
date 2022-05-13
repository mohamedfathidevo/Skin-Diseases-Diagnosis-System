package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.util

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DefaultAppBar(onNavigateButton: () -> Unit) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Result",
                fontSize = 25.sp
            )
        },
        navigationIcon = {
            IconButton(onClick = onNavigateButton){
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back" ,
                    tint = Color.Black,
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    )
}
package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.Icon
import androidx.compose.ui.res.painterResource
import com.mohamedfathidev.skindiseasesdiagnosissystem.R


@Composable
fun ShowAlertDialog(
    onDismissRequest :() -> Unit,
    onConfirmRequest :() -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = { Text( text = "No Internet Connection") },
        text = { Text( text = "please check your internet, try to open wifi or caller data and try again") },
        icon = { Icon(painterResource(id = R.drawable.ic_connectivity_unavailable), contentDescription = null) },
        confirmButton = {
            TextButton(
                onClick = onConfirmRequest
            ) {
                Text("Confirm")
            }
        },
    )
}
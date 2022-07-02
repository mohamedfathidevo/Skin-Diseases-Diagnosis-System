package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.result_screen.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohamedfathidev.skindiseasesdiagnosissystem.R

@Composable
fun SafeDiagnosis(
    showLoading: Boolean
) {
    if (showLoading){
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }else{
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier
                        .padding(15.dp)
                        .size(100.dp),
                    alignment = Alignment.Center,
                    painter = painterResource(id = R.drawable.you_are_save),
                    contentDescription = "you are save"
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "You Are Safe",
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 40.sp,
                        fontFamily = FontFamily.Monospace
                    ),
                    modifier = Modifier
                        .align(CenterHorizontally)
                        .padding(5.dp)
                )
            }
        }
    }
}
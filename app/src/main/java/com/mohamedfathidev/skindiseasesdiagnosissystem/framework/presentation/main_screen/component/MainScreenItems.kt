package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.main_screen.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mohamedfathidev.skindiseasesdiagnosissystem.R
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.ui.theme.buttonColor
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.util.ConnectivityStatus
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalAnimationApi::class, ExperimentalCoroutinesApi::class)
@Composable
fun MainScreenItems(
    navController: NavController,
    onClickContinueButton: () -> Unit,
    onClickAboutButton: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .align(Alignment.Center),
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
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black,
                            fontFamily = FontFamily(
                                Font(R.font.berkshire_swash_new)
                            ),
                            fontSize = 30.sp
                        )
                    ) {
                        append("Welcome to ")
                    }

                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = buttonColor,
                            fontFamily = FontFamily(
                                Font(R.font.berkshire_swash_new)
                            ),
                            fontSize = 30.sp
                        )
                    ) {
                        append("Skiner")
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
            )
            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
            Text(
                text = "Ai diseases Diagnostic " +
                        "System using Deep" +
                        " Learning, Neural Network" +
                        " and Image Processing",
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 8.dp)
            )
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            OutlinedButton(
                onClick = onClickContinueButton,
                modifier = Modifier
                    .padding(4.dp)
                    .width(240.dp)
                    .height(60.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, buttonColor)
            ) {
                Text(
                    text = "Continue",
                    style = TextStyle(
                        color = buttonColor,
                        fontSize = 20.sp
                    )
                )
            }
            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
            OutlinedButton(
                onClick = onClickAboutButton,
                modifier = Modifier
                    .padding(4.dp)
                    .width(240.dp)
                    .height(60.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, buttonColor)
            ) {
                Text(
                    text = "About",
                    style = TextStyle(
                        color = buttonColor,
                        fontSize = 20.sp
                    )
                )
            }
        }
    }

    ConnectivityStatus(
        navController = navController
    )
}
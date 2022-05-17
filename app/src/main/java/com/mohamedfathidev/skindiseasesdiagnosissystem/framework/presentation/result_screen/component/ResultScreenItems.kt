package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.result_screen.component

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mohamedfathidev.skindiseasesdiagnosissystem.R
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.model.Disease
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.util.Constant
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.util.DefaultAppBar

@Composable
fun ResultScreenItems(
    navController: NavController,
    diseases: List<Disease>,
    isLoading : Boolean,
    error: String
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            DefaultAppBar(
                onNavigateButton = {
                    navController.popBackStack()
                }
            )
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            if (!isLoading && error.isBlank()) {
                if (diseases.size == 1 && diseases[0].name == "normal"){
                    SafeDiagnosis()
                }else {
                    Column(
                        modifier = Modifier.padding(4.dp)
                    ) {
                        Text(
                            text = "You Have Been diagnosed\nWith",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black,
                            modifier = Modifier.padding(16.dp)
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        LazyColumn(
                            modifier = Modifier.padding(vertical = 4.dp),
                        ) {
                            items(items = diseases) { disease ->
                                Card(disease = disease)
                            }
                        }
                    }
                }
            }
            if (isLoading){
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ){
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }
            if (error.isNotBlank()){
                LaunchedEffect(true) {
                    Toast.makeText(context, "Error Happen while diagnosis", Toast.LENGTH_SHORT).show()
                    Log.d(Constant.TAG, "ResultScreen Error happen: $error")
                    navController.popBackStack()
                }
            }
        }
    }
}


@Composable
private fun Card(disease: Disease) {
    Card(
        backgroundColor = Color.White,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        elevation = 9.dp
    ) {
        CardContents(disease)
    }
}

@Composable
private fun CardContents(disease: Disease) {
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = disease.name)
            Text(
                text = disease.percentage,
                style = MaterialTheme.typography.h4.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            if (expanded) {
                Text(
                    text = ("You must visit the doctor ").repeat(7)
                )
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }

            )
        }
    }
}
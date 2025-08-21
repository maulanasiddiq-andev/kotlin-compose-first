package com.example.firstcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun SecondScreen(navHostController: NavHostController) {
    val scrollState = rememberScrollState()
    var textController by remember { mutableStateOf("") }

    Scaffold (
        topBar = { AppBarComponent("Halaman Kedua", navHostController) },
        bottomBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .imePadding()
                    .navigationBarsPadding()
                    .padding(10.dp, 5.dp, 10.dp, 5.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFF2196f3))
                        .padding(10.dp, 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Ke Halaman Ketiga",
                        style = TextStyle(
                            fontSize = 16.sp
                        ),
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .verticalScroll(scrollState)
                        .padding(10.dp, 0.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.foto),
                        contentDescription = "Foto",
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    repeat(25) { index ->
                        Text(
                            "Hello World di halaman ini yang ke-${index + 1}",
                            style = TextStyle(
                                fontSize = 16.sp
                            )
                        )
                    }
                    TextField(
                        value = textController,
                        onValueChange = { textController = it },
                        placeholder = { Text("Text Controller") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    repeat(40) { index ->
                        Text(
                            "Hello World di halaman ini yang ke-${index + 26}",
                            style = TextStyle(
                                fontSize = 16.sp
                            )
                        )
                    }
                }
            }
        }
    )
}
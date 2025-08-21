package com.example.firstcompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun ThirdScreen(navHostController: NavHostController) {
    Scaffold (
        topBar = { AppBarComponent("Halaman Ketiga", navHostController) },
        content = { padding ->
            Box (
                modifier = Modifier.fillMaxSize().padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Halaman Ketiga")
                    Button(
                        onClick = { navHostController.popBackStack() }
                    ) {
                        Text("Kembali")
                    }
                }
            }
        }
    )
}
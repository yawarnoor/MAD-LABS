package com.example.task2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

//@Composable
//fun Signup(navController: NavHostController, modifier: Modifier = Modifier) {
//    Box(
//        modifier = Modifier
//            .background(Color.Black)
//            .fillMaxSize()
//
//    ){
//        Column (
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier
//                .padding(55.dp)
//                .fillMaxSize()
//        ){
//            TextField(value = "Fullname",
//                onValueChange = {},
//                modifier = Modifier.padding(bottom = 10.dp)
//            )
//            TextField(value = "Email",
//                onValueChange = {},
//                modifier = Modifier.padding(bottom = 10.dp)
//            )
//            TextField(value = "Password",
//                onValueChange = {},
//                modifier = Modifier.padding(bottom = 30.dp)
//            )
//            Button(onClick = { /*TODO*/ },
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = Color.Magenta
//                ),
//                shape = RectangleShape,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(50.dp)
//            ) {
//                Text(text = "Register", fontSize = 20.sp, lineHeight = 20.sp)
//            }
//            Row (
//                horizontalArrangement = Arrangement.Center,
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier
//                    .padding(top = 50.dp)
//            ){
//                Text(text = "Already Registered !", color = Color.White, fontSize = 15.sp)
//                Button(onClick = {
//                    navController.popBackStack()
//                },
//                    colors =  ButtonDefaults.buttonColors(
//                        containerColor = Color.Black
//                    )
//                ) {
//                    Text(text = "Login Me", fontSize = 15.sp)
//                }
//            }
//        }
//    }
//}

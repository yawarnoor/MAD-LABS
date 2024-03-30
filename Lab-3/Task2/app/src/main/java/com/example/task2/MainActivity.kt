package com.example.task2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.task2.ui.theme.Task2Theme
import com.example.task2.Signup

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(){
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = "login" ){
        composable(route="login"){ Greeting(navigationController)}
        composable(route="signup"){ Signup(navController = navigationController) }
    }
}


@Composable
fun Greeting(navController: NavHostController
             , modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Green),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .padding(55.dp)
                .background(color = Color.Green),

            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = "Email",
                onValueChange = {},
                modifier = Modifier.padding(bottom = 15.dp)
            )
            TextField(
                value = "Password",
                onValueChange = {},
                modifier = Modifier.padding(bottom = 25.dp)
            )
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Login",
                    color = Color.Green
                )
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 25.dp)
            ) {
                Text(text = "Not a Member ?", fontSize = 15.sp, color = Color.White)
                Button(
                    onClick = {
                        navController.navigate("signup")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Green
                    )
                ) {
                    Text(text = "Sign Up Now", fontSize = 15.sp)
                }
            }

        }
    }
}

@Composable
fun Signup(navController: NavHostController, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()

    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(55.dp)
                .fillMaxSize()
        ){
            TextField(value = "Fullname",
                onValueChange = {},
                modifier = Modifier.padding(bottom = 10.dp)
            )
            TextField(value = "Email",
                onValueChange = {},
                modifier = Modifier.padding(bottom = 10.dp)
            )
            TextField(value = "Password",
                onValueChange = {},
                modifier = Modifier.padding(bottom = 30.dp)
            )
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Magenta
                ),
                shape = RectangleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Register", fontSize = 20.sp, lineHeight = 20.sp)
            }
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 50.dp)
            ){
                Text(text = "Already Registered !", color = Color.White, fontSize = 15.sp)
                Button(onClick = {
                    navController.popBackStack()
                },
                    colors =  ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    )
                ) {
                    Text(text = "Login Me", fontSize = 15.sp)
                }
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Task2Theme {
        //Greeting("Android")
    }
}
package com.example.task3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.task3.ui.theme.Task3Theme
import com.example.task3.PreviewComposable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    PreviewComposable(img = R.drawable.ross)
                    MyApp()
                }
            }
        }
    }
}


@Composable
fun MyApp() {
    val context = LocalContext.current
    val navigationController = rememberNavController()
    var selectedStars by remember { mutableStateOf(0) }
    NavHost(navController = navigationController, startDestination = "home") {
        composable(route = "home") {
            Greeting(navigationController, selectedStars) { stars ->
                selectedStars = stars
            }
        }
        composable(route = "preview/{personName}") { backStackEntry ->
            // Extract the person_name from the route parameters
            val personName = backStackEntry.arguments?.getString("personName") ?: ""

            PreviewComposable(personName, navigationController) { stars ->
                selectedStars = stars
                Toast.makeText(context, "${selectedStars}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun Greeting(navigationController : NavHostController, selectedStars : Int, onStarsSelected : (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp, start = 10.dp, end = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(text = "FriendSr", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "When clicked any image, use proper action to move to second screen with more detail of the clicked person", fontSize = 10.sp, lineHeight = 13.sp)
        Spacer(modifier = Modifier.height(15.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            content ={
                item {CreateCard(person_name = "Chandler", img = R.drawable.chandler, navigationController)}
                item {CreateCard(person_name = "Joey", img = R.drawable.joey, navigationController)}
                item {CreateCard(person_name = "Monica", img = R.drawable.monica, navigationController)}
                item {CreateCard(person_name = "Phoebe", img = R.drawable.phoebe, navigationController)}
                item {CreateCard(person_name = "Rachel", img = R.drawable.rachel, navigationController)}
                item {CreateCard(person_name = "Ross", img = R.drawable.ross, navigationController)}
            }
        )
    }
}

@Composable
fun CreateCard(person_name : String, img : Int, navigationController: NavHostController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 10.dp)
    ){
        Image(painter = painterResource(id = img),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .clickable {
                    navigationController.navigate("preview/$person_name")
                },
            contentScale = ContentScale.FillBounds
        )
        Text(text = "${person_name}")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Task3Theme {
//        Greeting("Android")
    }
}
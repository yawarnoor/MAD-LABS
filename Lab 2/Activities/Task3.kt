package com.example.lab2

import android.content.ClipData.Item
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.ui.theme.Lab2Theme

class Task3 : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           Scaffold(
               topBar = { TopAppBar(
                   modifier = Modifier.background(color = Color.Blue),
                   title = {
                       Text(text = "Lazy Grid Layout")
                   }

               )
               }
           ) {

               Column(
                   Modifier.padding(it)
               ) {
                   mainComposableTask4()
               }
           }
        }
    }
}

@Composable
fun mainComposableTask4() {
    val data = listOf(
        mapOf(
            "image" to painterResource(id = R.drawable.ironman),
            "title" to "Iron Man",
            "release" to "Tales of Suspense #39 in December 1962"
        ),
        mapOf(
            "image" to painterResource(id = R.drawable.blackwidow),
            "title" to "Black Widow",
            "release" to "May 7, 2021"
        ),
        mapOf(
            "image" to painterResource(id = R.drawable.deadpool),
            "title" to "Deadpool",
            "release" to "February 12, 2016"
        ),
        mapOf(
            "image" to painterResource(id = R.drawable.hulk),
            "title" to "The Incredible Hulk",
            "release" to "June 13, 2008"
        ),
        mapOf(
            "image" to painterResource(id = R.drawable.thor),
            "title" to "Thor",
            "release" to "May 6, 2011"
        ),
        mapOf(
            "image" to painterResource(id = R.drawable.wolverine),
            "title" to "X-Men Origins: Wolverine",
            "release" to "May 1, 2009"
        )
    )


    Box(
        Modifier.padding(20.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), content = {
                items(data.size){
                    Box {
                        Column {
                            Image(painter = data[it]["image"] as Painter,
                                contentDescription = "Images",
                                modifier = Modifier
                                    .size(200.dp)
                                    .fillMaxSize()


                            )
                            Row(
                                horizontalArrangement = Arrangement.Center

                            ) {
                                Text(text = data[it]["title"] as String, fontSize = 21.sp)
                            }
                        }
                    }
                }
            }

        )
    }



}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview4() {
    mainComposableTask4()
}
package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab2.ui.theme.Lab2Theme
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class Task2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                Modifier.background(color = Color.Gray)
            ){
                Column(
                    Modifier.padding(it)

                ) {
                    mainComposableTask3()
                }
            }
        }
    }
}

@Composable
fun mainComposableTask3() {
    val data = listOf(
        mapOf(
            "image" to painterResource(id = R.drawable.ironman),
            "title" to "Iron Man\n",
            "release" to "Tales of Suspense #39 in December 1962"
        ),
        mapOf(
            "image" to painterResource(id = R.drawable.blackwidow), 
            "title" to "Black Widow\n",
            "release" to "May 7, 2021"
        ),
        mapOf(
            "image" to painterResource(id = R.drawable.deadpool), 
            "title" to "Deadpool\n",
            "release" to "February 12, 2016"
        ),
        mapOf(
            "image" to painterResource(id = R.drawable.hulk), 
            "title" to "The Incredible Hulk\n",
            "release" to "June 13, 2008"
        ),
        mapOf(
            "image" to painterResource(id = R.drawable.thor), 
            "title" to "Thor\n",
            "release" to "May 6, 2011"
        ),
        mapOf(
            "image" to painterResource(id = R.drawable.wolverine), 
            "title" to "X-Men Origins: Wolverine\n",
            "release" to "May 1, 2009"
        )
    )


    LazyColumn {
        items(data, key = { it }) { item ->
            ListItem(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 10.dp)
                    .background(color = Color.White),
                colors = ListItemDefaults.colors(Color.White),

                headlineContent = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Image(
                            item["image"] as Painter,
                            contentDescription = "Iron Man",
                            Modifier.size(100.dp)
                        )
                        Column {
                            Text(text = item["title"] as String, fontSize = 22.sp)

                            Text(text = item["release"] as String)
                        }
                    }
                },
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview3() {
    mainComposableTask3()
}
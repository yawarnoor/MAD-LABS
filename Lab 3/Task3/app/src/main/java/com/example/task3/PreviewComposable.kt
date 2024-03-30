package com.example.task3

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.task3.ui.theme.Task3Theme
//
//@Composable
//fun personData(name : String){
//    if(name)
//}

@Composable
fun PreviewComposable(name : String ,navigationController : NavHostController, onStarsSelected : (Int) -> Unit){

    val descriptions = mapOf(
        "Chandler" to "Chandler Muriel Bing was born on April 8, 1968, to an erotic novelist mother and a transgender woman who later became the star of a Las Vegas drag show. He is of Scottish ancestry...",
        "Joey" to "Joey Francis Joey Tribbiani, Jr. was presumably born in 1969 as he talks about having turned 13 in 1982. He comes from an Italian American family of eight children. His father Joseph Tribbiani, Sr., after whom Joey is named, is a pipefitter and his mother's name is Gloria...",
        "Monica" to "Monica is the younger sister of Ross Geller. She is best friends with Rachel Green, Phoebe Buffay, Joey Tribbiani, and Ross's college roommate and best friend, Chandler Bing...",
        "Phoebe" to "Phoebe Buffay is a quirky and eccentric masseuse and musician. She shares an apartment with her best friend Monica Geller...",
        "Rachel" to "Rachel Karen Green is a fictional character, one of the six main characters who appeared in the American sitcom Friends...",
        "Ross" to "Ross Eustace Geller Ph.D. is one of the six main fictional characters of the American sitcom Friends...",
    )

    val images = mapOf(
        "Chandler" to R.drawable.chandlerpreview,
        "Joey" to R.drawable.joeypreview,
        "Monica" to R.drawable.monicapreview,
        "Phoebe" to R.drawable.phoebepreview,
        "Rachel" to R.drawable.rachelpreview,
        "Ross" to R.drawable.rosspreview
    )

    var selectedStars by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)

        ){
            repeat(5) { index ->
                Icon(
                    painter = painterResource(id = if(index < selectedStars) R.drawable.filledstar else R.drawable.unfilledstar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            selectedStars = index + 1
                            onStarsSelected(selectedStars)
                            navigationController.popBackStack()
                        }
                )
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Image(painter = painterResource(id = images[name] ?: R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            contentScale = ContentScale.FillHeight
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "${descriptions[name]}", fontSize = 20.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewComposable1() {
    Task3Theme {
//        Greeting("Android")
//        PreviewComposable(R.drawable.chandlerpreview)
    }
}
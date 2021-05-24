/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.data.Repository
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    MyTheme() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "list") {
            composable("list") { PuppiesList(Repository.getPuppies(), navController) }
            composable(
                route = "detail/{puppyId}",
                arguments = listOf(
                    navArgument("puppyId") {
                        type = NavType.IntType
                    }
                )
            ) { navBackStackEntry ->
                val puppyId = navBackStackEntry.arguments!!.getInt("puppyId")
                val puppy = Repository.getPuppies().first { it.id == puppyId }
                PuppyDetail(puppy, navController)
            }
        }
    }
}

@Composable
fun PuppiesList(puppies: List<Puppy>, navController: NavHostController?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Puppy Adoption App") },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Puppy Adoption App",
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
            )
        }
    ) {
        LazyColumn(
            content = {
                puppies.forEach { puppy ->
                    item {
                        PuppyItem(puppy = puppy, navController = navController)
                    }
                }
            }
        )
    }
}

@Composable
fun PuppyItem(puppy: Puppy, navController: NavHostController?) {
    Card(
        modifier =
        Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clickable {
                navController?.navigate("detail/${puppy.id}")
            },
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            PuppyImage(puppy, 72.dp)
            PuppyContent(puppy)
        }
    }
}

@Composable
private fun PuppyContent(puppy: Puppy) {
    Column(Modifier.padding(start = 16.dp)) {
        Text(text = puppy.name, style = MaterialTheme.typography.h5)
        Text(text = puppy.type)
        Text(text = puppy.gender + ", " + puppy.age)
        Row() {
            Icon(Icons.Rounded.LocationOn, contentDescription = "description")
            Text(text = puppy.distance)
        }
    }
}

@Composable
private fun PuppyImage(puppy: Puppy, imageSize: Dp) {
    Image(
        painter = painterResource(id = puppy.imageId),
        contentDescription = puppy.name,
        modifier = Modifier
            .wrapContentSize()
            .size(imageSize)
            .clip(RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun PuppyDetail(puppy: Puppy, navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Puppy: ${puppy.name}") },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "back",
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                navController.navigateUp()
                            },
                    )
                }
            )
        },
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            PuppyImage(puppy, 240.dp)
            PuppyContent(puppy)
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyApp()
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyApp()
}

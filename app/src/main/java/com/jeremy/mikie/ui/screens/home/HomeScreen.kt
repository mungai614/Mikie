package com.jeremy.mikie.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jeremy.mikie.navigation.ROUT_HOME
import com.jeremy.mikie.R
import com.jeremy.mikie.navigation.ROUT_ASSIST
import com.jeremy.mikie.navigation.ROUT_ORDER
import com.jeremy.mikie.navigation.ROUT_SAVED

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("what we offer!!") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Red,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },

        //BottomBar
        bottomBar = {
            NavigationBar(
                containerColor = Color.Red
            ){
                NavigationBarItem(
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Home") },
                    label = { Text("order") },
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0
                        navController.navigate(ROUT_ORDER)
                    }
                )

                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Saved Orders") },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                          navController.navigate(ROUT_SAVED)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Search") },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = {
                        selectedIndex = 0
                        navController.navigate(ROUT_HOME)
                    }
                )


            }
        },

        //FloatingActionButton
        floatingActionButton = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                FloatingActionButton(
                    onClick = { navController.navigate(ROUT_ASSIST) },
                    containerColor = Color.LightGray
                ) {
                    Icon(Icons.Default.Phone, contentDescription = "phone")
                }
                Spacer(modifier = Modifier.height(4.dp)) // Space between FAB and text
                Text(
                    text = "Help",
                    color = Color.Blue,
                    fontSize = 12.sp
                )
            }
        },

        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize().verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {


                //Main Contents of the page
                //start card
                Card (
                    modifier = Modifier
                        .height(100.dp)
                        .width(300.dp)
                ){

                    Row (
                        modifier = Modifier
                            .padding(13.dp)
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(R.drawable.smocha),
                            contentDescription = "home",

                        )
                        Spacer(modifier = Modifier.width(20.dp))
                        Column (

                        ){
                            Text(
                                text = "Food Name",
                                fontSize = 20.sp,
                                color = Color.Red,


                            )
                            Text(
                                text ="smocha",
                                fontSize = 15.sp,

                            )
                            Text(
                                text = "SH:90"
                            )

                        }




                    }


                }
                Spacer(modifier = Modifier.height(10.dp))
                //end of card
                //start of card 2
                Card (
                    modifier = Modifier
                        .height(100.dp)
                        .width(300.dp)
                ){

                    Row (
                        modifier = Modifier
                            .padding(13.dp)
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(R.drawable.smocha),
                            contentDescription = "home",

                            )
                        Spacer(modifier = Modifier.width(20.dp))
                        Column (

                        ){
                            Text(
                                text = "Food Name",
                                fontSize = 20.sp,
                                color = Color.Red,


                                )
                            Text(
                                text ="smocha mayai",
                                fontSize = 15.sp,

                                )
                            Text(
                                text = "SH:120"
                            )

                        }




                    }


                }
                Spacer(modifier = Modifier.height(10.dp))
                //end of card
                //start of card 3
                Card (
                    modifier = Modifier
                        .height(100.dp)
                        .width(300.dp)
                ){

                    Row (
                        modifier = Modifier
                            .padding(13.dp)
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(R.drawable.smokie),
                            contentDescription = "home",

                            )
                        Spacer(modifier = Modifier.width(20.dp))
                        Column (

                        ){
                            Text(
                                text = "Food Name",
                                fontSize = 20.sp,
                                color = Color.Red,


                                )
                            Text(
                                text ="smokie",
                                fontSize = 15.sp,

                                )
                            Text(
                                text = "SH:50"
                            )

                        }




                    }


                }
                Spacer(modifier = Modifier.height(10.dp))
                //end of card
                //start of card 4
                Card (
                    modifier = Modifier
                        .height(100.dp)
                        .width(300.dp)
                ){

                    Row (
                        modifier = Modifier
                            .padding(13.dp)
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(R.drawable.hotdog),
                            contentDescription = "home",

                            )
                        Spacer(modifier = Modifier.width(20.dp))
                        Column (

                        ){
                            Text(
                                text = "Food Name",
                                fontSize = 20.sp,
                                color = Color.Red,


                                )
                            Text(
                                text ="hot dog",
                                fontSize = 15.sp,

                                )
                            Text(
                                text = "SH:80"
                            )

                        }




                    }


                }
                Spacer(modifier = Modifier.height(10.dp))
                //end of card
                //start of card 5
                Card (
                    modifier = Modifier
                        .height(100.dp)
                        .width(300.dp)
                ){

                    Row (
                        modifier = Modifier
                            .padding(13.dp)
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(R.drawable.mayai),
                            contentDescription = "home",

                            )
                        Spacer(modifier = Modifier.width(20.dp))
                        Column (

                        ){
                            Text(
                                text = "Food Name",
                                fontSize = 20.sp,
                                color = Color.Red,


                                )
                            Text(
                                text ="mayai",
                                fontSize = 15.sp,

                                )
                            Text(
                                text = "SH:40"
                            )

                        }




                    }


                }
                Spacer(modifier = Modifier.height(10.dp))
                //end of card
                //start of card 6
                Card (
                    modifier = Modifier
                        .height(100.dp)
                        .width(300.dp)
                ){

                    Row (
                        modifier = Modifier
                            .padding(13.dp)
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(R.drawable.samosa),
                            contentDescription = "home",

                            )
                        Spacer(modifier = Modifier.width(20.dp))
                        Column (

                        ){
                            Text(
                                text = "Food Name",
                                fontSize = 20.sp,
                                color = Color.Red,


                                )
                            Text(
                                text ="samosa nyama",
                                fontSize = 15.sp,

                                )
                            Text(
                                text = "SH:60"
                            )

                        }




                    }


                }
                Spacer(modifier = Modifier.height(10.dp))
                //end of card
                Card (
                    modifier = Modifier
                        .height(100.dp)
                        .width(300.dp)
                ){

                    Row (
                        modifier = Modifier
                            .padding(13.dp)
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(R.drawable.samosa),
                            contentDescription = "home",

                            )
                        Spacer(modifier = Modifier.width(20.dp))
                        Column (

                        ){
                            Text(
                                text = "Food Name",
                                fontSize = 20.sp,
                                color = Color.Red,


                                )
                            Text(
                                text ="smocha viazi",
                                fontSize = 15.sp,

                                )
                            Text(
                                text = "SH:40"
                            )

                        }




                    }


                }
                Spacer(modifier = Modifier.height(10.dp))
                //end of card
                Card (
                    modifier = Modifier
                        .height(100.dp)
                        .width(300.dp)
                ){

                    Row (
                        modifier = Modifier
                            .padding(13.dp)
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Image(
                            painter = painterResource(R.drawable.samosa),
                            contentDescription = "home",

                            )
                        Spacer(modifier = Modifier.width(20.dp))
                        Column (

                        ){
                            Text(
                                text = "Food Name",
                                fontSize = 20.sp,
                                color = Color.Red,


                                )
                            Text(
                                text ="smocha dengu",
                                fontSize = 15.sp,

                                )
                            Text(
                                text = "SH:40"
                            )

                        }




                    }


                }
                Spacer(modifier = Modifier.height(10.dp))
                //end of card




















            }
        }
    )

    //End of scaffold





}
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}

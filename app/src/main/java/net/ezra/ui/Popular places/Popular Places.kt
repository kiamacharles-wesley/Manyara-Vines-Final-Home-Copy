package net.ezra.ui.Popular



import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import net.ezra.R

import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import net.ezra.BottomBar
import net.ezra.navigation.ROUTE_BEACHES
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_POPULAR_HOTELS
import net.ezra.navigation.ROUTE_RADDISONBLU
import net.ezra.navigation.ROUTE_RECOMMENDED_PLACES


@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RecommendedPlaces(navController: NavHostController) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Column (){
                        Text(text = " Popular Places",color=Color(0xfff8c471))
                    }

                    // Text(text = stringResource(id = R.string.apen))
                },
                navigationIcon = @Composable
                     {
                        IconButton(onClick = { navController.navigate(ROUTE_HOME) {
                            popUpTo(ROUTE_RECOMMENDED_PLACES) { inclusive = true }
                        } }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = null,
                                tint = Color(0xfff8c471)
                            )
                        }
                    }
                ,

                colors = topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color(0xfff8c471),

                    )

            )
        },
        content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.White)){

                LazyColumn (    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly){
                    item{

                        Spacer(modifier = Modifier.height(15.dp))

                        Row(Modifier.fillMaxWidth()){

                            Text(text = "")

                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp)
                                .border(
                                    shape = RoundedCornerShape(10.dp),
                                    width = 1.dp,
                                    color = Color.White
                                )
                                .shadow(elevation = 10.dp)
                                .clickable {
                                    navController.navigate(ROUTE_RADDISONBLU) {
                                        popUpTo(
                                            ROUTE_HOME
                                        )
                                    }
                                }
                        ) {
                            Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.Bottom,modifier = Modifier
                                .background(
                                    Color.White
                                )
                                .width(500.dp)) {
                                Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" )
                                Spacer(modifier = Modifier.width(10.dp))
                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {
                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Text(
                                            text = "Raddison Blu"
                                        )
                                    }
                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Icon(
                                            imageVector = Icons.Default.Place,
                                            contentDescription = ""
                                        )
                                        Text(text = "Nairobi", fontWeight = FontWeight.ExtraLight)
                                    }
                                }
                                Spacer(modifier = Modifier.width(10.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {


                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Text(text = "$30/night")
                                    }

                                    Row(horizontalArrangement = Arrangement.Absolute.Right) {

                                        Icon(
                                            imageVector = Icons.Default.Star,
                                            contentDescription = "Review",
                                            tint = Color.Yellow
                                        )


                                        Text(text = "4.9")
                                    }

                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp)
                                .border(
                                    shape = RoundedCornerShape(10.dp),
                                    width = 1.dp,
                                    color = Color.White
                                )
                                .shadow(elevation = 10.dp)
                                .clickable {
                                    navController.navigate(ROUTE_RADDISONBLU) {
                                        popUpTo(
                                            ROUTE_HOME
                                        )
                                    }
                                }
                        ) {
                            Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.Bottom,modifier = Modifier
                                .background(
                                    Color.White
                                )
                                .width(500.dp)) {
                                Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" )
                                Spacer(modifier = Modifier.width(10.dp))
                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {
                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Text(
                                            text = "Raddison Blu"
                                        )
                                    }
                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Icon(
                                            imageVector = Icons.Default.Place,
                                            contentDescription = ""
                                        )
                                        Text(text = "Nairobi", fontWeight = FontWeight.ExtraLight)
                                    }
                                }
                                Spacer(modifier = Modifier.width(10.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {


                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Text(text = "$30/night")
                                    }

                                    Row(horizontalArrangement = Arrangement.Absolute.Right) {

                                        Icon(
                                            imageVector = Icons.Default.Star,
                                            contentDescription = "Review",
                                            tint = Color.Yellow
                                        )


                                        Text(text = "4.9")
                                    }

                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp)
                                .border(
                                    shape = RoundedCornerShape(10.dp),
                                    width = 1.dp,
                                    color = Color.White
                                )
                                .shadow(elevation = 10.dp)
                                .clickable {
                                    navController.navigate(ROUTE_RADDISONBLU) {
                                        popUpTo(
                                            ROUTE_HOME
                                        )
                                    }
                                }
                        ) {
                            Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.Bottom,modifier = Modifier
                                .background(
                                    Color.White
                                )
                                .width(500.dp)) {
                                Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" )
                                Spacer(modifier = Modifier.width(10.dp))
                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {
                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Text(
                                            text = "Raddison Blu"
                                        )
                                    }
                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Icon(
                                            imageVector = Icons.Default.Place,
                                            contentDescription = ""
                                        )
                                        Text(text = "Nairobi", fontWeight = FontWeight.ExtraLight)
                                    }
                                }
                                Spacer(modifier = Modifier.width(10.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {


                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Text(text = "$30/night")
                                    }

                                    Row(horizontalArrangement = Arrangement.Absolute.Right) {

                                        Icon(
                                            imageVector = Icons.Default.Star,
                                            contentDescription = "Review",
                                            tint = Color.Yellow
                                        )


                                        Text(text = "4.9")
                                    }

                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp)
                                .border(
                                    shape = RoundedCornerShape(10.dp),
                                    width = 1.dp,
                                    color = Color.White
                                )
                                .shadow(elevation = 10.dp)
                                .clickable {
                                    navController.navigate(ROUTE_RADDISONBLU) {
                                        popUpTo(
                                            ROUTE_HOME
                                        )
                                    }
                                }
                        ) {
                            Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.Bottom,modifier = Modifier
                                .background(
                                    Color.White
                                )
                                .width(500.dp)) {
                                Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" )
                                Spacer(modifier = Modifier.width(10.dp))
                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {
                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Text(
                                            text = "Raddison Blu"
                                        )
                                    }
                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Icon(
                                            imageVector = Icons.Default.Place,
                                            contentDescription = ""
                                        )
                                        Text(text = "Nairobi", fontWeight = FontWeight.ExtraLight)
                                    }
                                }
                                Spacer(modifier = Modifier.width(10.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {


                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Text(text = "$30/night")
                                    }

                                    Row(horizontalArrangement = Arrangement.Absolute.Right) {

                                        Icon(
                                            imageVector = Icons.Default.Star,
                                            contentDescription = "Review",
                                            tint = Color.Yellow
                                        )


                                        Text(text = "4.9")
                                    }

                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp)
                                .border(
                                    shape = RoundedCornerShape(10.dp),
                                    width = 1.dp,
                                    color = Color.White
                                )
                                .shadow(elevation = 10.dp)
                                .clickable {
                                    navController.navigate(ROUTE_RADDISONBLU) {
                                        popUpTo(
                                            ROUTE_HOME
                                        )
                                    }
                                }
                        ) {
                            Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.Bottom,modifier = Modifier
                                .background(
                                    Color.White
                                )
                                .width(500.dp)) {
                                Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" )
                                Spacer(modifier = Modifier.width(10.dp))
                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {
                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Text(
                                            text = "Raddison Blu"
                                        )
                                    }
                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Icon(
                                            imageVector = Icons.Default.Place,
                                            contentDescription = ""
                                        )
                                        Text(text = "Nairobi", fontWeight = FontWeight.ExtraLight)
                                    }
                                }
                                Spacer(modifier = Modifier.width(10.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {


                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Text(text = "$30/night")
                                    }

                                    Row(horizontalArrangement = Arrangement.Absolute.Right) {

                                        Icon(
                                            imageVector = Icons.Default.Star,
                                            contentDescription = "Review",
                                            tint = Color.Yellow
                                        )


                                        Text(text = "4.9")
                                    }

                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp)
                                .border(
                                    shape = RoundedCornerShape(10.dp),
                                    width = 1.dp,
                                    color = Color.White
                                )
                                .shadow(elevation = 10.dp)
                                .clickable {
                                    navController.navigate(ROUTE_RADDISONBLU) {
                                        popUpTo(
                                            ROUTE_HOME
                                        )
                                    }
                                }
                        ) {
                            Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.Bottom,modifier = Modifier
                                .background(
                                    Color.White
                                )
                                .width(500.dp)) {
                                Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" )
                                Spacer(modifier = Modifier.width(10.dp))
                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {
                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Text(
                                            text = "Raddison Blu"
                                        )
                                    }
                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Icon(
                                            imageVector = Icons.Default.Place,
                                            contentDescription = ""
                                        )
                                        Text(text = "Nairobi", fontWeight = FontWeight.ExtraLight)
                                    }
                                }
                                Spacer(modifier = Modifier.width(10.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {


                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Text(text = "$30/night")
                                    }

                                    Row(horizontalArrangement = Arrangement.Absolute.Right) {

                                        Icon(
                                            imageVector = Icons.Default.Star,
                                            contentDescription = "Review",
                                            tint = Color.Yellow
                                        )


                                        Text(text = "4.9")
                                    }

                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(15.dp)
                                .border(
                                    shape = RoundedCornerShape(10.dp),
                                    width = 1.dp,
                                    color = Color.White
                                )
                                .shadow(elevation = 10.dp)
                                .clickable {
                                    navController.navigate(ROUTE_RADDISONBLU) {
                                        popUpTo(
                                            ROUTE_HOME
                                        )
                                    }
                                }
                        ) {
                            Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.Bottom,modifier = Modifier
                                .background(
                                    Color.White
                                )
                                .width(500.dp)) {
                                Image(painter = painterResource(id = R.drawable.img_4), contentDescription = "" )
                                Spacer(modifier = Modifier.width(10.dp))
                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {
                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Text(
                                            text = "Raddison Blu"
                                        )
                                    }
                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Icon(
                                            imageVector = Icons.Default.Place,
                                            contentDescription = ""
                                        )
                                        Text(text = "Nairobi", fontWeight = FontWeight.ExtraLight)
                                    }
                                }
                                Spacer(modifier = Modifier.width(10.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left) {


                                    Row(horizontalArrangement = Arrangement.Absolute.Left) {
                                        Text(text = "$30/night")
                                    }

                                    Row(horizontalArrangement = Arrangement.Absolute.Right) {

                                        Icon(
                                            imageVector = Icons.Default.Star,
                                            contentDescription = "Review",
                                            tint = Color.Yellow
                                        )


                                        Text(text = "4.9")
                                    }

                                }
                            }
                        }
                    }
                }
            }
        },




    )




}





package net.ezra.ui.search


import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import net.ezra.R
import net.ezra.navigation.ROUTE_CART

import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_MOUNTAINS
import net.ezra.navigation.ROUTE_RADDISONBLU
import net.ezra.navigation.ROUTE_SEARCH
import net.ezra.navigation.ROUTE_VASCODAGAMA
import net.ezra.navigation.ROUTE_WILDLIFE

data class Screen(val title: String, val icon: Int)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)

@Composable

fun SearchScreen(navController: NavHostController) {

    data class YourDataClass(

        val beaches: String? = "",
        val wildlife: String? = "",
        val lakes: String? = "",
        val deserts: String? = "",
        val culture: String? = "",
        val mountains: String? = "",
        val Kenya_classics: String? = "",
        val Along_Rift_valley: String? = "",
        val Cities_of_Kenya: String? = "",
        val Time_travel: String? = "",
        val Karibu_Kenya: String? = "",
        val Summit_Madness: String? = "",
        val Vasco_da_gama: String? = "",
        val Hells_gate: String? = "",
        val Wilderbeasts: String? = "",
        val flamingos: String? = "",
        val hot_springs: String? = "",
        val fort_Jesus: String? = "",
        val recommended_packages: String? = "",
        val popular_places: String? = "",
        val Hotels: String? = "",
        val imageUrl: String? = "",


    )
    var isDrawerOpen by remember { mutableStateOf(false) }

    val callLauncher: ManagedActivityResultLauncher<Intent, ActivityResult> =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartActivityForResult()) { _ ->

        }

    var searchText by remember { mutableStateOf(TextFieldValue()) }
    var filteredData by remember { mutableStateOf(emptyList<YourDataClass>()) }

    // Firestore reference
    val firestore = Firebase.firestore

    DisposableEffect(searchText.text) {
        val query = firestore.collection("Destination")
            .whereGreaterThanOrEqualTo("DestinationName", searchText.text)
            .whereLessThanOrEqualTo("DestinationName", searchText.text + "\uf8ff")


        val listener = query.addSnapshotListener { snapshot, error ->
            if (error != null) {
                // Handle error
                return@addSnapshotListener
            }

            snapshot?.let {
                val data = it.toObjects(YourDataClass::class.java)
                filteredData = data
            }
        }

        onDispose {
            listener.remove()
        }
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Column (){
                        Text(text = " Search")
                    }

                    // Text(text = stringResource(id = R.string.apen))
                },
                navigationIcon = @Composable {
                    if (!isDrawerOpen) {
                        IconButton(onClick = { isDrawerOpen = true }) {
                            Icon(
                                imageVector = Icons.Filled.AccountCircle,
                                contentDescription = null,
                                tint = Color(0xfff8c471)
                            )
                        }
                    }
                },

                actions = {

                    IconButton(onClick = {
                        navController.navigate(ROUTE_LOGIN) {
                            popUpTo(ROUTE_HOME) { inclusive = true }
                        }

                    }) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "notificationIcon",
                            modifier = Modifier.size(20.dp),
                            tint = Color(0xfff8c471)
                        )
                    } },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color(0xfff8c471),

                    )

            )
        },
        content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(Color.White)){

                LazyColumn (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly)
                {



                    item{

                        Spacer(modifier = Modifier.height(15.dp))

                        Row(Modifier.fillMaxWidth()){

                            Text(text = "")

                        }

                        Spacer(modifier = Modifier.height(15.dp) )

                        Spacer(modifier = Modifier.height(15.dp))

                        Row(Modifier.fillMaxWidth()){

                            Text(text = "")

                        }

                        Spacer(modifier = Modifier.height(15.dp) )
                        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Absolute.Center, verticalAlignment = Alignment.CenterVertically) {
                            var text by remember { mutableStateOf(TextFieldValue("")) }
                            OutlinedTextField(
                                value = text,
                                trailingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "searchIcon",modifier=Modifier.clickable {  navController.navigate(ROUTE_HOME) { popUpTo(
                                    ROUTE_WILDLIFE
                                )} }) },
                                //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
                                onValueChange = {
                                    text = it
                                },
                                label = { Text(text = "Search destination") },
                                placeholder = { Text(text = "Search destination") },
                                modifier = Modifier
                                    .background(Color.White)
                                    .width(300.dp)
                                    .fillMaxWidth(),
                                shape = RoundedCornerShape(15.dp)
                            )
                        }
                    Spacer(modifier = Modifier.height(20.dp))

                        LazyRow(modifier=Modifier.fillMaxWidth()) {

                            item {
                                Card(modifier = Modifier
                                    .padding(15.dp)
                                    .border(
                                        shape = RoundedCornerShape(10.dp),
                                        width = 1.dp,
                                        color = Color.White
                                    )
                                    .shadow(elevation = 10.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_MOUNTAINS) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    }
                                    .width(210.dp)) {
                                    Column(modifier = Modifier.background(
                                        Color.White)) {
                                        Image(painter = painterResource(id = R.drawable.img_17), contentDescription = "" , modifier = Modifier
                                            .width(205.dp)
                                            .padding(5.dp), contentScale = ContentScale.FillWidth)
                                        Row(modifier=Modifier.fillMaxWidth()){
                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left){
                                                Text(text = "Along Rift Valley")
                                                Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                                                    Icon(imageVector =Icons.Default.LocationOn , contentDescription ="",modifier=Modifier.size(15.dp) )
                                                    Text(text = "Turkana-Kajiado",fontWeight = FontWeight.ExtraLight)
                                                }

                                            }
                                            Spacer(modifier = Modifier.width(40.dp))

                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Right){
                                                Text(text = "3 Days")
                                                Text(text = "2 Nights")
                                            }

                                        }

                                    }
                                }
                                Spacer(modifier = Modifier.width(15.dp))
                                Card(modifier = Modifier
                                    .padding(15.dp)
                                    .border(
                                        shape = RoundedCornerShape(10.dp),
                                        width = 1.dp,
                                        color = Color.White
                                    )
                                    .shadow(elevation = 10.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_MOUNTAINS) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    }
                                    .width(210.dp)) {
                                    Column(modifier = Modifier.background(
                                        Color.White)) {
                                        Image(painter = painterResource(id = R.drawable.img_17), contentDescription = "" , modifier = Modifier
                                            .width(205.dp)
                                            .padding(5.dp), contentScale = ContentScale.FillWidth)
                                        Row(modifier=Modifier.fillMaxWidth()){
                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left){
                                                Text(text = "Summit Madness")
                                                Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                                                    Icon(imageVector =Icons.Default.LocationOn , contentDescription ="",modifier=Modifier.size(15.dp) )
                                                    Text(text = "Mombasa-Kajiado",fontWeight = FontWeight.ExtraLight)
                                                }

                                            }
                                            Spacer(modifier = Modifier.width(40.dp))

                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Right){
                                                Text(text = "4 Days")
                                                Text(text = "3 Nights")
                                            }

                                        }

                                    }
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Card(modifier = Modifier
                                    .padding(15.dp)
                                    .border(
                                        shape = RoundedCornerShape(10.dp),
                                        width = 1.dp,
                                        color = Color.White
                                    )
                                    .shadow(elevation = 10.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_MOUNTAINS) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    }
                                    .width(210.dp)) {
                                    Column(modifier = Modifier.background(
                                        Color.White)) {
                                        Image(painter = painterResource(id = R.drawable.img_17), contentDescription = "" , modifier = Modifier
                                            .width(205.dp)
                                            .padding(5.dp), contentScale = ContentScale.FillWidth)
                                        Row(modifier=Modifier.fillMaxWidth()){
                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left){
                                                Text(text = "Kenya Classics")
                                                Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                                                    Icon(imageVector =Icons.Default.LocationOn , contentDescription ="",modifier=Modifier.size(15.dp) )
                                                    Text(text = "Nairobi-Mombasa",fontWeight = FontWeight.ExtraLight)
                                                }

                                            }
                                            Spacer(modifier = Modifier.width(40.dp))

                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Right){
                                                Text(text = "10 Days")
                                                Text(text = "9 Nights")
                                            }

                                        }

                                    }
                                }

                                Spacer(modifier = Modifier.width(15.dp))
                                Card(modifier = Modifier
                                    .padding(15.dp)
                                    .border(
                                        shape = RoundedCornerShape(10.dp),
                                        width = 1.dp,
                                        color = Color.White
                                    )
                                    .shadow(elevation = 10.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_MOUNTAINS) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    }
                                    .width(210.dp)) {
                                    Column(modifier = Modifier.background(
                                        Color.White)) {
                                        Image(painter = painterResource(id = R.drawable.img_17), contentDescription = "" , modifier = Modifier
                                            .width(205.dp)
                                            .padding(5.dp), contentScale = ContentScale.FillWidth)
                                        Row(modifier=Modifier.fillMaxWidth()){
                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left){
                                                Text(text = "Time Travel")
                                                Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                                                    Icon(imageVector =Icons.Default.LocationOn , contentDescription ="",modifier=Modifier.size(15.dp) )
                                                    Text(text = "Mombasa-Turkana",fontWeight = FontWeight.ExtraLight)
                                                }

                                            }
                                            Spacer(modifier = Modifier.width(40.dp))

                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Right){
                                                Text(text = "5 Days")
                                                Text(text = "4 Nights")
                                            }

                                        }

                                    }
                                }

                                Spacer(modifier = Modifier.width(15.dp))
                                Card(modifier = Modifier
                                    .padding(15.dp)
                                    .border(
                                        shape = RoundedCornerShape(10.dp),
                                        width = 1.dp,
                                        color = Color.White
                                    )
                                    .shadow(elevation = 10.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_MOUNTAINS) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    }
                                    .width(210.dp)) {
                                    Column(modifier = Modifier.background(
                                        Color.White)) {
                                        Image(painter = painterResource(id = R.drawable.img_17), contentDescription = "" , modifier = Modifier
                                            .width(205.dp)
                                            .padding(5.dp), contentScale = ContentScale.FillWidth)
                                        Row(modifier=Modifier.fillMaxWidth()){
                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left){
                                                Text(text = "Karibu Kenya")
                                                Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                                                    Icon(imageVector =Icons.Default.LocationOn , contentDescription ="",modifier=Modifier.size(15.dp) )
                                                    Text(text = "Kiambu-Mombasa",fontWeight = FontWeight.ExtraLight)
                                                }

                                            }
                                            Spacer(modifier = Modifier.width(40.dp))

                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Right){
                                                Text(text = "7 Days")
                                                Text(text = "6 Nights")
                                            }

                                        }

                                    }
                                }
                                Spacer(modifier = Modifier.width(15.dp))
                                Card(modifier = Modifier
                                    .padding(15.dp)
                                    .border(
                                        shape = RoundedCornerShape(10.dp),
                                        width = 1.dp,
                                        color = Color.White
                                    )
                                    .shadow(elevation = 10.dp)
                                    .clickable {
                                        navController.navigate(ROUTE_MOUNTAINS) {
                                            popUpTo(
                                                ROUTE_HOME
                                            )
                                        }
                                    }
                                    .width(210.dp)) {
                                    Column(modifier = Modifier.background(
                                        Color.White)) {
                                        Image(painter = painterResource(id = R.drawable.img_17), contentDescription = "" , modifier = Modifier
                                            .width(205.dp)
                                            .padding(5.dp), contentScale = ContentScale.FillWidth)
                                        Row(modifier=Modifier.fillMaxWidth()){
                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Left){
                                                Text(text = "Cities of Kenya")
                                                Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                                                    Icon(imageVector =Icons.Default.LocationOn , contentDescription ="",modifier=Modifier.size(15.dp) )
                                                    Text(text = "Mombasa-Kisumu",fontWeight = FontWeight.ExtraLight)
                                                }

                                            }
                                            Spacer(modifier = Modifier.width(40.dp))

                                            Column (verticalArrangement = Arrangement.Center, horizontalAlignment = AbsoluteAlignment.Right){
                                                Text(text = "3 Days")
                                                Text(text = "2 Nights")
                                            }

                                        }

                                    }
                                }

                            }
                        }

                     Spacer(modifier = Modifier.height(20.dp))

                        LazyRow (modifier = Modifier.fillMaxWidth()){
                            item {

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                    Card (shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_VASCODAGAMA) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        }){
                                        Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                                    }
                                    Text(text = "Vasco da Gama")
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                    Card (shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_VASCODAGAMA) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        }){
                                        Image(painter = painterResource(id = R.drawable.img_15), contentDescription = "", modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop)
                                    }
                                    Text(text = "Fort Jesus")
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                    Card (shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_VASCODAGAMA) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        }){
                                        Image(painter = painterResource(id = R.drawable.img_16), contentDescription = "", modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop)
                                    }
                                    Text(text = "Hell's gate")
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                    Card (shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_VASCODAGAMA) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        }){
                                        Image(painter = painterResource(id = R.drawable.img_10), contentDescription = "", modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop)
                                    }
                                    Text(text = "Wildebeests")
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                    Card (shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_VASCODAGAMA) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        }){
                                        Image(painter = painterResource(id = R.drawable.img_11), contentDescription = "", modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop)
                                    }
                                    Text(text = "Fourteen falls")
                                }
                                Spacer(modifier = Modifier.width(15.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                                    Card (shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_VASCODAGAMA) {
                                                popUpTo(
                                                    ROUTE_HOME
                                                )
                                            }
                                        }){
                                        Image(painter = painterResource(id = R.drawable.img_19), contentDescription = "", modifier = Modifier.fillMaxSize(),contentScale = ContentScale.Crop)
                                    }
                                    Text(text = "Hot Springs")
                                }
                                Spacer(modifier = Modifier.width(10.dp))

                                Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                                    Card(shape = CircleShape, modifier = Modifier
                                        .size(80.dp)
                                        .clickable {
                                            navController.navigate(ROUTE_HOME) {
                                                popUpTo(
                                                    ROUTE_VASCODAGAMA
                                                )
                                            }
                                        }) {
                                        Image(
                                            painter = painterResource(id = R.drawable.img_18),
                                            contentDescription = "",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                    }
                                    Text(text = "Flamingos")



                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        Column (modifier = Modifier.fillMaxWidth()) {

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

                        Spacer(modifier = Modifier.height(15.dp))

                        Row(Modifier.fillMaxWidth()){

                            Text(text = "")

                        }

                        Spacer(modifier = Modifier.height(15.dp) )

                    }

                }
            }
        },
        bottomBar = {BottomBar(navController)}



    )

    AnimatedDrawer(
        isOpen = isDrawerOpen,
        onClose = { isDrawerOpen = false }
    )

}


@Composable
fun AnimatedDrawer(isOpen: Boolean, onClose: () -> Unit) {
    val drawerWidth = remember { Animatable(if (isOpen) 250f else 0f) }





    LaunchedEffect(isOpen) {
        drawerWidth.animateTo(if (isOpen) 250f else 0f, animationSpec = tween(durationMillis = 300))
    }

    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .width(drawerWidth.value.dp),
        color = Color.White,
        // color = Color.LightGray,
        elevation = 16.dp
    ) {


        val mContext = LocalContext.current

        Column {
            Row(horizontalArrangement = Arrangement.Absolute.Right, verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = ""
                )
                Column () {
                    Text(
                        text = "Alala Amka",
                        modifier = Modifier.clickable { },
                        color= Color(0xfff8c471),
                        fontWeight = FontWeight.ExtraBold
                    )

                    Text(
                        text = "View profile",
                        modifier = Modifier.clickable { },
                        color=  Color(0xfff8c471),
                        fontWeight = FontWeight.ExtraLight
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row() {
                Icon(imageVector = Icons.Default.Info, contentDescription = "", tint =  Color(0xfff8c471) )
                Text(text = "What's new",
                    color=  Color(0xfff8c471),
                    modifier = Modifier.clickable { })
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row() {
                Icon(imageVector = Icons.Default.Create, contentDescription = "", tint =  Color(0xfff8c471) )
                Text(text = "History",
                    color=  Color(0xfff8c471),
                    modifier = Modifier.clickable { })
            }

            Spacer(modifier = Modifier.height(30.dp))
            Row() {
                Icon(imageVector = Icons.Default.Settings, contentDescription = "", tint =  Color(0xfff8c471) )
                Text(text = "Settings and privacy",
                    color=  Color(0xfff8c471),
                    modifier = Modifier.clickable { })
            }



        }
    }


}
@Composable
fun BottomBar(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(
        elevation = 10.dp,
        backgroundColor = Color.White,
        contentColor = Color(0xfff8c471),
    )
    {
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home, "", tint = Color(0xfff8c471))
        },
            label = { Text(text = "Home", color = Color(0xfff8c471)) },
            selected = (selectedIndex.value == 0),
            onClick = {
                navController.navigate(ROUTE_HOME) { popUpTo(ROUTE_SEARCH) }

            }
            ,selectedContentColor = Color.Black
        )
        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Search, "", tint = Color(0xfff8c471))
        },
            label = { Text(text = "Search", color = Color(0xfff8c471)) },
            selected = (selectedIndex.value == 0),
            onClick = {
                navController.navigate(ROUTE_SEARCH) { popUpTo(ROUTE_SEARCH) }
            }
            ,selectedContentColor = Color.Black
        )

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.ShoppingCart, "", tint = Color(0xfff8c471))
        },
            label = { Text(text = "Cart", color = Color(0xfff8c471)) },
            selected = (selectedIndex.value == 2),
            onClick = {
                navController.navigate(ROUTE_CART) { popUpTo(ROUTE_SEARCH) }
            }
            ,selectedContentColor = Color.Black
        )
    }
}














@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    SearchScreen(rememberNavController())
}


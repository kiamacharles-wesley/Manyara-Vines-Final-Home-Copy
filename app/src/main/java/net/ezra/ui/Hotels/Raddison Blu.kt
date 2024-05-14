package net.ezra.ui.Hotels

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.CartItemList
import net.ezra.ItemList
import net.ezra.R
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_MOUNTAINS

import net.ezra.navigation.ROUTE_SHOP

@Composable
fun RaddisonBlu(navController: NavHostController) {

    val mContext = LocalContext.current
    LazyColumn (modifier=Modifier.fillMaxSize()){
        item{
            Card (modifier=Modifier.fillMaxSize().height(400.dp)){


                Image(painter = painterResource(id = R.drawable.img_21), contentDescription ="",modifier=Modifier.fillMaxSize(), contentScale = ContentScale.Crop )

            }
            Spacer(modifier = Modifier.height(15.dp))

            LazyRow (modifier = Modifier.fillMaxWidth()){
                item{
                    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                        Card (shape = CircleShape, modifier = Modifier
                            .size(60.dp)
                            .clickable { navController.navigate(ROUTE_HOME) { popUpTo(
                                ROUTE_MOUNTAINS
                            ) } }){
                            Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                        }
                        Text(text = "Guides",fontWeight = FontWeight.ExtraBold)
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                        Card (shape = CircleShape, modifier = Modifier
                            .size(60.dp)
                            .clickable { navController.navigate(ROUTE_HOME) { popUpTo(
                                ROUTE_MOUNTAINS
                            ) } }){
                            Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                        }
                        Text(text = "Map",fontWeight = FontWeight.ExtraBold)
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                        Card (shape = CircleShape, modifier = Modifier
                            .size(60.dp)
                            .clickable { navController.navigate(ROUTE_HOME) { popUpTo(
                                ROUTE_MOUNTAINS
                            ) } }){
                            Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                        }
                        Text(text = "Transport",fontWeight = FontWeight.ExtraBold)
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                        Card (shape = CircleShape, modifier = Modifier
                            .size(60.dp)
                            .clickable { navController.navigate(ROUTE_HOME) { popUpTo(
                                ROUTE_MOUNTAINS
                            ) } }){
                            Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                        }
                        Text(text = "Contacts",fontWeight = FontWeight.ExtraBold)
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                        Card (shape = CircleShape, modifier = Modifier
                            .size(60.dp)
                            .clickable { navController.navigate(ROUTE_HOME) { popUpTo(
                                ROUTE_MOUNTAINS
                            ) } }){
                            Image(painter = painterResource(id = R.drawable.img_14), contentDescription = "", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
                        }
                        Text(text = "Reviews",fontWeight = FontWeight.ExtraBold)
                    }


                }

            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(){
                Text(text = "Description", fontWeight = FontWeight.ExtraBold)

            }
            Spacer(modifier = Modifier.height(5.dp))

            Row (){
                Text(text = "  Located in the vibrant heart of Nairobi, Radisson Blu embodies contemporary elegance and African hospitality. Its sleek design, luxurious accommodations, and state-of-the-art facilities cater to discerning travelers seeking comfort and convenience. Indulge in exquisite dining experiences, unwind in stylish lounges, or rejuvenate in the spa and fitness center. With its central location and impeccable service, Radisson Blu Nairobi is the perfect urban retreat for business meetings, leisure getaways, and exploration of Kenya's capital city.")
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row( horizontalArrangement = Arrangement.Absolute.SpaceEvenly, verticalAlignment = Alignment.Bottom){

                Button(
                    onClick = {

                        val simToolKitLaunchIntent =
                            mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                    },
                    colors = ButtonDefaults.buttonColors(Color.Black)

                ) {
                    Text(text = "Book Now", color = Color.White)
                }
                Spacer(modifier = Modifier.width(100.dp))

                Button(
                    onClick = {
                         },
                    colors = ButtonDefaults.buttonColors(Color.Black)

                ) {
                    Text(text = "Add Cart", color = Color.White)
                }


            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    RaddisonBlu(rememberNavController())
}


package net.ezra.ui


import android.content.res.Configuration
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import net.ezra.R
import net.ezra.navigation.ROUTE_HOME



@Composable
fun SplashScreen(navController: NavHostController) {

    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // Animation
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            // tween Animation
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                }))
        // Customize the delay time
        delay(3000L)
        navController.navigate(ROUTE_HOME)
    }

    // Image

 Box {
     Row(
         Modifier.fillMaxSize()
                 .padding(10.dp),
         horizontalArrangement = Arrangement.Center,
         verticalAlignment = Alignment.Top,

     ) {
         Image(painter = painterResource(id = R.drawable.img_24), contentDescription = "",
             contentScale = ContentScale.Inside)
     }

     Column (
         verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally,
         modifier = Modifier.fillMaxSize()

     ){


         Text("Manyara Vines", fontWeight = FontWeight.Thin, fontFamily = FontFamily.Cursive ,   fontSize = 45.sp, lineHeight = 52.sp, letterSpacing = 0.sp)



     }

     Row (
         horizontalArrangement = Arrangement.Center,
         verticalAlignment = Alignment.Bottom,
         modifier = Modifier.fillMaxSize()
     ){
         Column (
             verticalArrangement = Arrangement.Bottom,
             horizontalAlignment = Alignment.CenterHorizontally,
             modifier = Modifier.fillMaxSize()
         ){

             Text("Powered by", fontWeight = FontWeight.Thin, fontFamily = FontFamily.Serif,  fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.4.sp)

             Text("Kiama", fontWeight = FontWeight.Thin,fontFamily = FontFamily.Serif,  fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.4.sp)



         }





     }


 }



}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    SplashScreen(rememberNavController())
}


package net.ezra

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavHostController
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

import androidx.lifecycle.ViewModel
import androidx.navigation.ActivityNavigator
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import net.ezra.R
import net.ezra.navigation.ROUTE_HISTORY
import net.ezra.navigation.ROUTE_HOME



data class Destination(

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

) {

}


class FirestoreViewModel : ViewModel() {

    private val firestore = Firebase.firestore
    private val itemsCollection = firestore.collection("Students")

    private val _items = MutableLiveData<List<Destination>>()
    val items: LiveData<List<Destination>> = _items

    init {
        fetchItems()
    }

    fun fetchItems() {
        itemsCollection.addSnapshotListener { snapshot, error ->
            if (error != null) {
                Log.e("FirestoreViewModel", "Error fetching students", error)
                return@addSnapshotListener
            }

            val itemList = mutableListOf<Destination>()
            snapshot?.documents?.forEach { document ->
                val item = document.toObject(Destination::class.java)
                item?.let {
                    itemList.add(it)
                }
            }
            _items.value = itemList
        }
    }
}


@Composable
fun DestinationsList(items: List<Destination>) {

    Column {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            items.forEach { item ->
                item {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){

                        SubcomposeAsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(item.imageUrl)
                                .crossfade(true)
                                .build(),
                            loading = {
                                CircularProgressIndicator()
                            },
                            contentDescription = item.wildlife,
                            modifier = Modifier
                                .clip(RoundedCornerShape(10))
                                .size(150.dp)

                        )

                        item.mountains?.let { Text(text = it) }
                        item.beaches?.let { Text(text = it) }
                        item.recommended_packages?.let { Text(text = it) }
                        item.lakes?.let { Text(text = it) }
                        item.culture?.let { Text(text = it) }
                        item.popular_places?.let { Text(text = it) }
                        item.wildlife?.let { Text(text = it) }
                        item.Kenya_classics?.let { Text(text = it) }
                        item.Along_Rift_valley?.let { Text(text = it) }
                        item.Cities_of_Kenya?.let { Text(text = it) }
                        item.Time_travel?.let { Text(text = it) }
                        item.Karibu_Kenya?.let { Text(text = it) }
                        item.Summit_Madness?.let { Text(text = it) }
                        item.Vasco_da_gama?.let { Text(text = it) }
                        item.Hells_gate?.let { Text(text = it) }
                        item.Wilderbeasts?.let { Text(text = it) }
                        item.flamingos?.let { Text(text = it) }
                        item.hot_springs?.let { Text(text = it) }
                        item.Hotels?.let { Text(text = it) }

                    }

                }
            }


        }
    }
}




@SuppressLint("ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Destinations(navController: NavHostController, viewModel: FirestoreViewModel) {
    val items by viewModel.items.observeAsState(initial = emptyList())

    // Fetch items when the composable is first created
    LaunchedEffect(viewModel) {
        viewModel.fetchItems()
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Destinations")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(ROUTE_HOME) {
                            popUpTo(ROUTE_HISTORY) { inclusive = true }
                        }
                    }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            "backIcon",
                            tint = Color.White
                        )
                    }
                },


                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },
                colors = topAppBarColors(
                    containerColor = Color(0xff0FB06A),


                    titleContentColor = Color.White,
                ),
            )
        },

        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(Color(0xff9AEDC9)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                DestinationsList(items)


            }
        },


        )
}






package xcom.niteshray.apps.tweetsy.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import xcom.niteshray.apps.tweetsy.R
import xcom.niteshray.apps.tweetsy.viewModels.TweetViewModel

@Composable
fun Home(modifier: Modifier,onClick : (category : String) -> Unit) {
    val categoryViewModel : TweetViewModel = hiltViewModel()
    var category: State<List<String>> = categoryViewModel.category.collectAsState()
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(category.value.distinct()){
            CategoryItem(it,modifier = Modifier.clickable {
                onClick(it)
            })
        }
    }

}

@Composable
fun CategoryItem(category: String, modifier: Modifier) {
    Box(
        modifier = modifier
            .padding(16.dp)
            .size(160.dp)
            .clip(RoundedCornerShape(16.dp))
            .rotate(180F)
            .paint(painterResource(R.drawable.stacked_waves_haikei),
                contentScale = ContentScale.Crop),
        contentAlignment = Alignment.TopCenter
    ){
       Text(text = category, modifier = Modifier
           .padding(0.dp, 20.dp)
           .rotate(180F),
           style = MaterialTheme.typography.bodyLarge,
           fontSize = 18.sp,
           color = Color.Black
       )
    }
}






























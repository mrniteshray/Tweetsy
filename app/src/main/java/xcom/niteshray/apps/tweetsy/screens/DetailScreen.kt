package xcom.niteshray.apps.tweetsy.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import xcom.niteshray.apps.tweetsy.models.Tweets
import xcom.niteshray.apps.tweetsy.viewModels.TweetViewModel

@Composable
fun DetailScreen(modifier: Modifier,category : String) {
    val viewmodel : TweetViewModel = hiltViewModel()
    val tweetlist: State<List<Tweets>> = viewmodel.tweets.collectAsState()
    LazyColumn(
        modifier = modifier
    ){
        items(tweetlist.value){
            if (it.category == category){
                DetailScreenItem(it.text)
            }
        }
    }
}

//@Preview(showSystemUi = true)
@Composable
fun DetailScreenItem(tweet : String) {
    Card( elevation = CardDefaults.cardElevation(8.dp),modifier = Modifier.fillMaxWidth().padding(16.dp),
        border = BorderStroke(1.dp, Color.Black),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Text(tweet,
            fontSize = 16.sp,
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.labelMedium,
            color = Color.Black
        )
    }
}
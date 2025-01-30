package xcom.niteshray.apps.tweetsy.repository

import androidx.compose.runtime.MutableState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import xcom.niteshray.apps.tweetsy.api.TweetsApi
import xcom.niteshray.apps.tweetsy.models.Tweets
import javax.inject.Inject

class TweetRepo @Inject constructor(val tweetspi : TweetsApi) {

    private val _category = MutableStateFlow<List<String>>(emptyList())
    val category : StateFlow<List<String>> get() = _category

    private val _tweets = MutableStateFlow<List<Tweets>>(emptyList())
    val tweets : StateFlow<List<Tweets>> get() = _tweets

    suspend fun fetchCategory(){
            val reposnse = tweetspi.getCategory()
            if(reposnse.isSuccessful && reposnse.body()!=null){
                _category.emit(reposnse.body()!!.distinct())
        }
    }

    suspend fun fetchTweets(){
            val response = tweetspi.getTweets()
            if (response.isSuccessful && response.body() != null){
                _tweets.emit(response.body()!!.tweets)
            }

    }
}
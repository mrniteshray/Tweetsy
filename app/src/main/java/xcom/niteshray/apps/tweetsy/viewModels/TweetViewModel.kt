package xcom.niteshray.apps.tweetsy.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import xcom.niteshray.apps.tweetsy.models.Tweets
import xcom.niteshray.apps.tweetsy.repository.TweetRepo
import javax.inject.Inject

@HiltViewModel
class TweetViewModel @Inject constructor(val repo: TweetRepo) : ViewModel() {

    val category : StateFlow<List<String>>
        get() = repo.category

    val tweets : StateFlow<List<Tweets>>
        get() = repo.tweets

    init {
        viewModelScope.launch {
            repo.fetchTweets()
            repo.fetchCategory()
        }
    }
}
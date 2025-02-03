package xcom.niteshray.apps.tweetsy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import xcom.niteshray.apps.tweetsy.screens.DetailScreen
import xcom.niteshray.apps.tweetsy.screens.Home
import xcom.niteshray.apps.tweetsy.ui.theme.TweetsyTheme
import xcom.niteshray.apps.tweetsy.viewModels.TweetViewModel
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TweetsyTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Tweetsy", color = Color.White) },
                            colors = TopAppBarDefaults.topAppBarColors(Color.Black)
                        )
                    }
                   , modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App(modifier = Modifier.padding(innerPadding).background(Color.White))
                }
            }
        }
    }

    @Composable
    fun App(modifier: Modifier){
        val navController = rememberNavController()
        NavHost( navController = navController , startDestination = "home"){
            composable(route = "home"){
                Home(modifier){
                    navController.navigate("Detail/$it")
                }
            }
            composable(route = "Detail/{category}", arguments = listOf(
                navArgument("category"){
                    type = NavType.StringType
                }
            )) {
                DetailScreen(modifier,it.arguments?.getString("category")!!)
            }
        }
    }

}


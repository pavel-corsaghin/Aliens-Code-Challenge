package com.example.alienscodechallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alienscodechallenge.data.model.response.NewsResponse
import com.example.alienscodechallenge.ui.detail.DetailScreen
import com.example.alienscodechallenge.ui.list.ListScreen
import com.example.alienscodechallenge.ui.theme.AliensCodeChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AliensCodeChallengeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = NavDestinations.LIST_SCREEN,
                    ) {
                        composable(NavDestinations.LIST_SCREEN) {
                            ListScreen(navController)
                        }
                        composable("${NavDestinations.DETAIL_SCREEN}/{newsId}") {
                            it.arguments?.getString("newsId")?.let { newsId ->
                                DetailScreen(newsId, navController)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AliensCodeChallengeTheme {
        ListScreen(
            navController = rememberNavController(),
            newsList = NewsResponse.mock().news ?: emptyList()
        )
    }
}
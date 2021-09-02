package com.example.alienscodechallenge.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.alienscodechallenge.R
import com.example.alienscodechallenge.data.model.response.NewsResponse
import com.example.alienscodechallenge.domain.model.News
import com.example.alienscodechallenge.ui.theme.AliensCodeChallengeTheme

@Composable
fun DetailScreen(
    newsId: String,
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val news by viewModel.news.observeAsState(initial = null)
    viewModel.getNewsById(newsId)
    DetailScreen(navController, news)
}

@Composable
fun DetailScreen(
    navController: NavController,
    news: News?,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(news?.title ?: "", maxLines = 1, overflow = TextOverflow.Ellipsis) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                }
            )
        }
    ) {
        news?.let {
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.padding(8.dp).fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
            ) {
                Column {
                    Image(
                        modifier = Modifier.fillMaxWidth().aspectRatio(16f / 9f),
                        painter = rememberImagePainter(
                            data = news.imageUrl,
                            builder = {
                                placeholder(R.drawable.placeholder)
                                error(R.drawable.placeholder)
                            }
                        ),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth
                    )
                    Column(Modifier.padding(8.dp)) {
                        Text(news.title ?: "", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text(news.content ?: "")
                    }
                }
            }
        } ?: run {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DetailsPreview() {
    AliensCodeChallengeTheme {
        DetailScreen(
            navController = rememberNavController(),
            news = NewsResponse.mock().news?.firstOrNull()
        )
    }
}

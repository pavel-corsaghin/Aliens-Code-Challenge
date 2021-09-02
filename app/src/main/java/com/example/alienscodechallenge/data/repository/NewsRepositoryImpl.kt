package com.example.alienscodechallenge.data.repository

import com.example.alienscodechallenge.data.model.response.NewsResponse
import com.example.alienscodechallenge.data.service.NewsService
import com.example.alienscodechallenge.domain.model.News
import com.example.alienscodechallenge.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService
) : NewsRepository {

    override suspend fun getNewsList(): List<News> {
//        val apiResponse = newsService.getNews().body()
//        if (apiResponse?.status != 200) {
//            throw Exception("An error occurred when get news")
//        }
//
//        return apiResponse.news ?: emptyList()

        // Todo: remove mock and use real handler above
        return NewsResponse.mock().news ?: emptyList()
    }

    override suspend fun getNewsDetail(id: String): News {
        // Todo: remove mock and use real handler
        return NewsResponse.mock().news?.find { it -> it.id == id }
            ?: throw Exception("An error occurred when get new detail")
    }
}
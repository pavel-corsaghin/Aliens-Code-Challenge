package com.example.alienscodechallenge.data.repository

import com.example.alienscodechallenge.data.model.response.NewsResponse
import com.example.alienscodechallenge.data.service.NewsService
import com.example.alienscodechallenge.domain.model.News
import com.example.alienscodechallenge.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService
) : NewsRepository {

    override suspend fun getNews(): List<News> {
        val apiResponse = newsService.getNews().body()
//        if (apiResponse?.status != 200) {
//            throw Exception("An error occurred when call API")
//        }
//
//        return apiResponse.news ?: emptyList()

        // Todo: remove mock and use real handler above
        return NewsResponse.mock().news ?: emptyList()
    }

    override suspend fun getNew(id: Int): News {
        TODO("Not yet implemented")
    }
}
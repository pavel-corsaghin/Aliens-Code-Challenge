package com.example.alienscodechallenge.data.service

import com.example.alienscodechallenge.data.model.response.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("/v1/news")
    suspend fun getNews(
        @Query("page") page: Int = 0,
        @Query("size") size: Int = 5
    ): Response<NewsResponse>
}
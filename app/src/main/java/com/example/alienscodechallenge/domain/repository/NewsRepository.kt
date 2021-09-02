package com.example.alienscodechallenge.domain.repository

import com.example.alienscodechallenge.domain.model.News

interface NewsRepository {
    suspend fun getNewsList(): List<News>

    suspend fun getNewsDetail(id: String): News
}
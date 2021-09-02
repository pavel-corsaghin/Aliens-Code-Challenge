package com.example.alienscodechallenge.domain.repository

import com.example.alienscodechallenge.domain.model.News

interface NewsRepository {
    suspend fun getNews(): List<News>

    suspend fun getNew(id: Int): News
}
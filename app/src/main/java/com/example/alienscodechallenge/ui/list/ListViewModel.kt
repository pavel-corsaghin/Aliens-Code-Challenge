package com.example.alienscodechallenge.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.alienscodechallenge.domain.model.News
import com.example.alienscodechallenge.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    private val _newsList = MutableLiveData<List<News>>()
    val newsList: LiveData<List<News>> = _newsList

    fun getNewsList() {
        viewModelScope.launch(Dispatchers.IO) {
            val news = repository.getNewsList()
            _newsList.postValue(news)
        }
    }
}
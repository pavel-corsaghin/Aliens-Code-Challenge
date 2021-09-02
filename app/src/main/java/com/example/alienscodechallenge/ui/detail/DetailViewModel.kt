package com.example.alienscodechallenge.ui.detail

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
class DetailViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    private val _showSmartMode = MutableLiveData(true)
    val showSmartMode: LiveData<Boolean> = _showSmartMode

    private val _news = MutableLiveData<News>()
    val news: LiveData<News> = _news

    fun getNewsById(newsId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val news = repository.getNewsDetail(newsId)
            _news.postValue(news)
        }
    }

    fun toggleMode()  {
        _showSmartMode.value = !_showSmartMode.value!!
    }
}
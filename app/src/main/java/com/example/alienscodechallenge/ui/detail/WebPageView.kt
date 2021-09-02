package com.example.alienscodechallenge.ui.detail

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebPageView(urlToRender: String) {
    var isLoading by rememberSaveable { mutableStateOf(true) }

    WebPageView(urlToRender = urlToRender,
        isLoading = isLoading,
        setLoading = { isLoading = it })
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebPageView(urlToRender: String, isLoading: Boolean, setLoading: (Boolean) -> Unit) {

    if (isLoading) {
        CircularProgressIndicator()
    }
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = object : WebViewClient() {

                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    setLoading(true)
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    setLoading(false)
                }
            }
            loadUrl(urlToRender)
        }

    }, update = {
        it.loadUrl(urlToRender)
    })

    if (isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    }

}
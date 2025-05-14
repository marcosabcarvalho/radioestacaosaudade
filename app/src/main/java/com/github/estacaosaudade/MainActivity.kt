package com.github.estacaosaudade

import android.webkit.WebChromeClient

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyWebView()
        }
    }
}

@Composable
fun MyWebView() {
    AndroidView(factory = { context ->
        WebView(context).apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true  // localStorage
            settings.databaseEnabled = true    // suporte extra a armazenamento
            settings.mediaPlaybackRequiresUserGesture = false
            settings.allowContentAccess = true
            settings.allowFileAccess = true
            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient() // Permite JS avançado e autoplay

            loadUrl("https://radio.ideiasbits.com.br/radio.html")
        }
    })
}



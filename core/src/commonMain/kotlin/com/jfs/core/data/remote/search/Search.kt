package com.jfs.core.data.remote.search

import io.ktor.client.request.*
import io.ktor.client.statement.*

import io.ktor.client.*

class Search {
    private val apiKey = "d87441150cbb23717c2e0f6d46d24bc6"
    private val client = HttpClient()

    suspend fun makeRequest(): HttpResponse {
        return client.request("https://api.themoviedb.org/3/search/movie?api_key=$apiKey&language=en-US&query=last&page=1&include_adult=false") {
            // Configure request parameters exposed by HttpRequestBuilder
        }
    }
}
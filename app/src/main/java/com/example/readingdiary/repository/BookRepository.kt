package com.example.readingdiary.repository

import android.util.Log
import com.example.readingdiary.api.ApiAccess
import com.example.readingdiary.api.ApiBook
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class BookRepository (
    val httpClient: HttpClient = ApiAccess().createHttpClient()
) {

    suspend fun loadBookList() {
       val apiBookList: List<ApiBook> = httpClient.get("https://www.googleapis.com/books/v1/volumes").body()
        Log.i("BookRepository", "loadBookList: $apiBookList")
    }

}

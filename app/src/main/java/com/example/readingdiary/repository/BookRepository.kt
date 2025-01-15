package com.example.readingdiary.repository

import android.util.Log
import com.example.readingdiary.Book
import com.example.readingdiary.BookData
import com.example.readingdiary.api.ApiAccess
import com.example.readingdiary.api.ApiBook
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

var repository = BookRepository()

class BookRepository(
    val httpClient: HttpClient = ApiAccess().createHttpClient()
) {
    private var readBooks = BookData.booksReadList

    //Zeile wird dann aufgerufen, wenn der Konstruktor aufgerufen wird, daher werden die Bücher nicht doppelt gezeigt
    //Variable darf nicht null sein
    private var wishListBooks = BookData.booksOnWishList

    fun readAllReadBooks(): List<Book> {
        return readBooks
    }

    fun readAllWishListBooks(): List<Book> {
        return wishListBooks
    }

    fun loadNewReadList() {
        //in dem Moment, wo Load-Methode gerufen wird, wird diese Liste erzeugt
        val newReadList = readBooks + wishListBooks
        readBooks = newReadList as ArrayList<Book>
    }

    fun loadNewWishList() {
        val newWishList = wishListBooks + readBooks
        wishListBooks = newWishList as ArrayList<Book>
    }

    suspend fun loadBookList() {
        val apiBookList: List<ApiBook> =
            httpClient.get("https://www.googleapis.com/books/v1/volumes").body()
        Log.i("BookRepository", "loadBookList: $apiBookList")
    }


}


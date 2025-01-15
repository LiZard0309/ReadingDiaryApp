package com.example.readingdiary.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.readingdiary.Book
import com.example.readingdiary.BookData
import com.example.readingdiary.api.ApiAccess
import com.example.readingdiary.api.GoogleBooksResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

var repository = BookRepository()

class BookRepository(
    val httpClient: HttpClient = ApiAccess().createHttpClient()
) {

    private val _readBooks = MutableLiveData<ArrayList<Book>>(ArrayList())
    val readBooks: LiveData<ArrayList<Book>> get() = _readBooks

    private val _wishListBooks = MutableLiveData<ArrayList<Book>>(ArrayList())
    val wishListBooks: LiveData<ArrayList<Book>> get() = _wishListBooks

    fun readAllReadBooks(): LiveData<ArrayList<Book>> {
        return readBooks
    }

    fun readAllWishListBooks(): LiveData<ArrayList<Book>> {
        return wishListBooks
    }

    fun addToReadList(book: Book) {
        val currentReadList = _readBooks.value ?: ArrayList()
        currentReadList.add(book)
        _readBooks.value = currentReadList
    }

    fun addToWishList(book: Book) {
        val currentWishList = _wishListBooks.value ?: ArrayList()
        currentWishList.add(book)
        _readBooks.value = currentWishList
    }



    suspend fun searchBooks(searchTerm: String): List<Book> {
        return try {
            val apiBookList: GoogleBooksResponse = withContext(Dispatchers.IO) {
                launch { delay(3000) }
                httpClient.get("https://www.googleapis.com/books/v1/volumes?q=$searchTerm").body()
            }


            apiBookList.items?.map { volume ->
                Book(
                    bookTitle = volume.volumeInfo.bookTitle,
                    bookAuthor = volume.volumeInfo.bookAuthors?.joinToString(", ")
                        ?: "Unknown Author",
                    bookDescription = volume.volumeInfo.description ?: "No description available",
                )


            } ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }


    }
}


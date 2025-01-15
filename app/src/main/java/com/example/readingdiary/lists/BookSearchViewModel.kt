package com.example.readingdiary.lists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.readingdiary.Book
import com.example.readingdiary.repository.repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BookSearchViewModel() : ViewModel() {

    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> get() = _books


    fun onSearchTermEntered(searchTerm: String) {


        viewModelScope.launch(Dispatchers.IO) {

            val results = repository.searchBooks(searchTerm)

            withContext(Dispatchers.Main) {
                _books.value = results
            }
        }
    }

}
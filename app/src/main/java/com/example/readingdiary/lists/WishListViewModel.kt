package com.example.readingdiary.lists

import androidx.lifecycle.ViewModel
import com.example.readingdiary.repository.repository

class WishListViewModel(): ViewModel() {
    fun readAll() = repository.readAllWishListBooks()

    fun refreshTriggered() {
        repository.loadNewWishList()
    }
}
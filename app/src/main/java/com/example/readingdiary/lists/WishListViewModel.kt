package com.example.readingdiary.lists

import androidx.lifecycle.ViewModel
import com.example.readingdiary.repository.repository

class WishListViewModel(): ViewModel() {
    val wishListBooks = repository.wishListBooks

    fun readAll() = repository.readAllWishListBooks()
}
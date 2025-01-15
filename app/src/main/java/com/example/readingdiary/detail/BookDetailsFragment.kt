package com.example.readingdiary.detail

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.readingdiary.R
import com.google.android.material.textfield.TextInputEditText

class BookDetailsFragment : Fragment(R.layout.fragment_book_details) {
    private val bookDetailViewModel: BookDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bookData = bookDetailViewModel.read()

        val etBookTitle = view.findViewById<TextInputEditText>(R.id.etBookTitle)
        val etAuthor = view.findViewById<TextInputEditText>(R.id.etAuthor)
        val etDescription = view.findViewById<TextInputEditText>(R.id.etDescription)

        etBookTitle.setText(bookData.bookTitle)
        etAuthor.setText(bookData.bookAuthor)
        etDescription.setText(bookData.bookDescription)

        val buttonAddToReadList = view.findViewById<Button>(R.id.btnAddToReadlist)
        val buttonAddToWishlist = view.findViewById<Button>(R.id.btnAddToWishlist)
        val buttonBack = view.findViewById<Button>(R.id.btnBack)

        buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }



    }

}
package com.example.readingdiary.detail

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.readingdiary.R
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class BookDetailsFragment : Fragment(R.layout.fragment_book_details) {
    private val bookDetailViewModel: BookDetailViewModel by viewModels()
    private lateinit var constraintLayout: ConstraintLayout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bookData = bookDetailViewModel.read()

        val etBookTitle = view.findViewById<TextInputEditText>(R.id.etBookTitle)
        val etAuthor = view.findViewById<TextInputEditText>(R.id.etAuthor)
        val etDescription = view.findViewById<TextInputEditText>(R.id.etDescription)

        constraintLayout = view.findViewById(R.id.constraintLayout)

        etBookTitle.setText(bookData.bookTitle)
        etAuthor.setText(bookData.bookAuthor)
        etDescription.setText(bookData.bookDescription)

        val buttonAddToReadList = view.findViewById<Button>(R.id.btnAddToReadlist)
        val buttonAddToWishlist = view.findViewById<Button>(R.id.btnAddToWishlist)
        val buttonBack = view.findViewById<Button>(R.id.btnBack)

        val snackbarReadList: Snackbar = Snackbar.make(constraintLayout, "Book added to read list", Snackbar.LENGTH_LONG)
        val snackbarWishList: Snackbar = Snackbar.make(constraintLayout, "Book added to wish list", Snackbar.LENGTH_LONG)

        buttonBack.setOnClickListener {
            findNavController().popBackStack()
        }

        buttonAddToWishlist.setOnClickListener {
            bookDetailViewModel.addToWishList(bookData)
            snackbarWishList.show()
            findNavController().popBackStack()
        }

        buttonAddToReadList.setOnClickListener {
            bookDetailViewModel.addToReadList(bookData)
            snackbarReadList.show()
            findNavController().popBackStack()
        }

    }

}
package com.example.demo.controller

import com.example.demo.domain.Book
import com.example.demo.domain.BookRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/books")
class BookController(
    val bookRepository: BookRepository
) {
    @PostMapping
    fun create(@RequestParam title: String) {
        bookRepository.save(Book(title))
    }

    @GetMapping
    fun findAll(): List<Book> {
        return bookRepository.findAll()
    }

}
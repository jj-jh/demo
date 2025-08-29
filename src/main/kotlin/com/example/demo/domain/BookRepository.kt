package com.example.demo.domain

import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<Book, Long>
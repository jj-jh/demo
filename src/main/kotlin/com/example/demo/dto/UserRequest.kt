package com.example.demo.dto

import com.example.demo.domain.User
import org.jetbrains.annotations.NotNull

data class UserRequest(

    @field:NotNull
    val email: String,

    @field:NotNull
    val password: String,

    @field:NotNull
    val nickname: String,

    @field:NotNull
    val age: Int,

    @field:NotNull
    val grade: String,
)

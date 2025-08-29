package com.example.demo.dto

import com.example.demo.domain.User

data class UserResponse(
    val id: Long?,
    val email: String,
    val nickname: String,
    val age: Int,
    val grade: String,
) {
    companion object {
        fun from(entity: User) = UserResponse(
            id = entity.id,
            email = entity.email,
            nickname = entity.nickName,
            age = entity.age,
            grade = entity.grade,
        )
    }
}
package com.example.demo.controller

import com.example.demo.domain.User
import com.example.demo.domain.UserRepository
import com.example.demo.dto.UserRequest
import com.example.demo.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserService
) {

    @PostMapping
    fun joinIn(
        @RequestBody request: UserRequest
    ) {
        userService.signUp(request)
    }
}
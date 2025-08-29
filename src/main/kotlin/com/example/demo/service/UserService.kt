package com.example.demo.service

import com.example.demo.config.CryptoConfig
import com.example.demo.domain.User
import com.example.demo.domain.UserRepository
import com.example.demo.dto.UserRequest
import com.example.demo.dto.UserResponse
import jakarta.transaction.Transactional
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    val userRepository: UserRepository,
    val passwordEncoder: PasswordEncoder
) {

    @Transactional
    fun signUp(request: UserRequest): ResponseEntity<UserResponse> {

        if (userRepository.existsByEmail(request.email)) {
            throw IllegalArgumentException("이미 가입된 이메일입니다.")
        }
        val user = User(
            email = request.email,
            passwdHash = passwordEncoder.encode(request.password),
            nickName = request.nickname,
            age = request.age,
            grade = request.grade,
        )
        return ResponseEntity.ok(UserResponse.from(userRepository.save(user)))

    }
}
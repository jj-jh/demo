package com.example.demo.exception

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    private val logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    data class ErrorResponse(val code: String, val message: String)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleIllegalArg(e: IllegalArgumentException): ResponseEntity<ErrorResponse> {
        logger.warn("Bad request", e)
        return ResponseEntity(ErrorResponse("BAD_REQUEST", e.message ?: "잘못된 요청"), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<ErrorResponse> {
        logger.warn("Not found", e)
        return ResponseEntity(ErrorResponse("NOT_FOUND", e.message ?: "리소스를 찾을 수 없음"), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(e: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        val msg = e.bindingResult.fieldErrors.joinToString { "${it.field}: ${it.defaultMessage}" }
        logger.warn("Validation error: {}", msg)
        return ResponseEntity(ErrorResponse("VALIDATION_ERROR", msg), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    fun handleEtc(e: Exception): ResponseEntity<ErrorResponse> {
        logger.error("Unhandled exception", e)  // ← 스택트레이스 로그
        return ResponseEntity(ErrorResponse("INTERNAL_ERROR", "서버 오류"), HttpStatus.INTERNAL_SERVER_ERROR)
    }
}

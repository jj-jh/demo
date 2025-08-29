package com.example.demo.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import java.sql.Timestamp
import java.time.LocalDateTime

@Table(
    name = "app_user",
    uniqueConstraints = [UniqueConstraint(columnNames = ["nickname", "email"])]
)
@Entity
class User(

    @Column(nullable = false)
    val email: String,

    @Column(nullable = false, name = "passwd_hash")
    val passwdHash: String,

    @Column(nullable = false, name = "nickname")
    var nickName: String,

    @Column(nullable = false)
    val age: Int,

    @Column(nullable = false)
    val grade: String,


    val createAt: LocalDateTime? = LocalDateTime.now(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
) {


}
package com.bangkit.kevin.dicodingstoryapp

data class LoginResponse(
    val error: Boolean,
    val loginResult: LoginResult,
    val message: String
)
data class LoginResult(
    val name: String,
    val token: String,
    val userId: String
)
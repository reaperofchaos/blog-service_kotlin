package com.jacobconner.blog.data



data class UserDto (
    val login: String,
    val firstname: String,
    val lastname: String,
    val description: String?,
    val id: Long?)

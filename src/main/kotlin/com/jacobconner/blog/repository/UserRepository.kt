package com.jacobconner.blog.repository

import com.jacobconner.blog.domain.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long> {
    fun findByLogin(login: String): User?
    override fun findAll(): List<User>
}
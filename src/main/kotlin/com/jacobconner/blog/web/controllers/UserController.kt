package com.jacobconner.blog.web.controllers

import com.jacobconner.blog.repository.UserRepository
import com.jacobconner.blog.service.impl.UserService
import com.jacobconner.blog.service.mapper.UserMapper
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

class UserController {
    @RestController
    @RequestMapping("/api/v1/user")
    class UserController(private val repository: UserRepository){
        val mapper: UserMapper = UserMapper()
        val userService: UserService = UserService(repository, mapper)

        @GetMapping("/")
        fun findAll() = userService.getUsers()

        @GetMapping("/{login}")
        fun findOne(@PathVariable login: String) =
            userService.getUserByLogins(login) ?: throw
            ResponseStatusException(HttpStatus.NOT_FOUND, "This user does not exist")
    }
}
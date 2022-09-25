package com.jacobconner.blog.service.impl

import com.jacobconner.blog.data.UserDto
import com.jacobconner.blog.domain.User
import com.jacobconner.blog.repository.UserRepository
import com.jacobconner.blog.service.mapper.UserMapper

class UserService(private val repository: UserRepository, private val mapper: UserMapper) {

    fun getUsers(): List<UserDto> {
        val users: List<User> = repository.findAll()
        val userDtos: MutableList<UserDto> = mutableListOf()

        for (user in users) {
            userDtos.add(mapper.toUserDto(user))
        }
        return userDtos
    }

    fun getUserByLogins(login: String): UserDto? {
        val user: User? = repository.findByLogin(login)
        if(user !== null){
            return mapper.toUserDto(user);
        }
        return null;
    }

}
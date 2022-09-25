package com.jacobconner.blog.service.mapper

import com.jacobconner.blog.data.UserDto
import com.jacobconner.blog.domain.User

class UserMapper {
    fun toUserDto(user: User): UserDto {
        return UserDto(
            login = user.login,
            firstname = user.firstname,
            lastname = user.lastname,
            description = user.description,
            id = user.id)
    }

    fun toUser(user: UserDto): User {
        return User(
            login = user.login,
            firstname = user.firstname,
            lastname = user.lastname,
            description = user.description,
            id = user.id)
    }
}
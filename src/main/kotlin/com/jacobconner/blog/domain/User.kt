package com.jacobconner.blog.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User (
    var login: String,
    var firstname: String,
    var lastname: String,
    var description: String? = null,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null)

package com.jacobconner.blog.data

import com.jacobconner.blog.domain.User

data class RenderedArticleDTO(
    val slug: String,
    val title: String,
    val headline: String,
    val content: String,
    val author: User,
    val addedAt: String)
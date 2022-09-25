package com.jacobconner.blog.data

import com.jacobconner.blog.domain.User
import java.time.LocalDateTime


data class ArticleDto (
    val title: String,
    val headline: String,
    val content: String,
    val author: User,
    val slug: String,
    val addedAt: LocalDateTime,
)
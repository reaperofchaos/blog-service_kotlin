package com.jacobconner.blog.repository

import com.jacobconner.blog.domain.Article
import org.springframework.data.repository.CrudRepository

interface ArticleRepository: CrudRepository<Article, Long> {
    fun findBySlug(slug: String): Article?
    fun findAllByOrderByAddedAtDesc(): List<Article>
}
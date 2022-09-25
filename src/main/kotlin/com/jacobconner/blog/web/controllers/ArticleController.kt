package com.jacobconner.blog.web.controllers

import com.jacobconner.blog.repository.ArticleRepository
import com.jacobconner.blog.service.impl.ArticleService
import com.jacobconner.blog.service.mapper.ArticleMapper
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/article")
class ArticleController(private val repository: ArticleRepository){
    final val mapper: ArticleMapper = ArticleMapper()
    val service: ArticleService = ArticleService(repository, mapper)

    @GetMapping("/")
    fun findAll() = service.getAllArticles()

    @GetMapping("/{slug}")
    fun findONe(@PathVariable slug: String) =
        service.getArticleBySlug(slug) ?: throw
        ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist")
}
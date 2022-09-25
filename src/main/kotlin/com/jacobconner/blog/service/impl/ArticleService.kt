package com.jacobconner.blog.service.impl

import com.jacobconner.blog.data.ArticleDto
import com.jacobconner.blog.domain.Article
import com.jacobconner.blog.repository.ArticleRepository
import com.jacobconner.blog.service.mapper.ArticleMapper

class ArticleService(private val repository: ArticleRepository, private val mapper: ArticleMapper) {

    fun getAllArticles(): List<ArticleDto>{
        val articles: List<Article> = repository.findAllByOrderByAddedAtDesc()
        val articleDtos: MutableList<ArticleDto> = mutableListOf()

        for (article in articles) {
            articleDtos.add(mapper.toArticleDto(article))
        }
        return articleDtos
    }

    fun getArticleBySlug(slug: String): ArticleDto? {
        val article: Article? = repository.findBySlug(slug)
        if(article !== null){
            return mapper.toArticleDto(article)
        }
        return null;
    }

}
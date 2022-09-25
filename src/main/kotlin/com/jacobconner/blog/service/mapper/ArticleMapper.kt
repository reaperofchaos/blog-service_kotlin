package com.jacobconner.blog.service.mapper

import com.jacobconner.blog.data.ArticleDto
import com.jacobconner.blog.domain.Article

class ArticleMapper {
    fun toArticleDto(article: Article): ArticleDto {
        return ArticleDto(
            title = article.title,
            headline = article.headline,
            content = article.content,
            author = article.author,
            slug = article.slug,
            addedAt = article.addedAt)
    }

    fun toArticle(article: ArticleDto): Article {
        return Article(
            title = article.title,
            headline = article.headline,
            content = article.content,
            author = article.author,
            slug = article.slug,
            addedAt = article.addedAt)
    }
}
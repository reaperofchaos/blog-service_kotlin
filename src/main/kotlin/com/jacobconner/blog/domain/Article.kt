package com.jacobconner.blog.domain

import com.jacobconner.blog.data.RenderedArticleDTO
import com.jacobconner.blog.format
import com.jacobconner.blog.toSlug
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Article(
    var title: String,
    var headline: String,
    var content: String,
    @ManyToOne
    var author: User,
    var slug: String = title.toSlug(),
    var addedAt: LocalDateTime = LocalDateTime.now(),
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null)
{
    fun render():RenderedArticleDTO {
        return RenderedArticleDTO(
            slug,
            title,
            headline,
            content,
            author,
            addedAt.format()
        )
    }
}
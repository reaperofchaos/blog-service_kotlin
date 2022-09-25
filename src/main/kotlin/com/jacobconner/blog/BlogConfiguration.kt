package com.jacobconner.blog

import com.jacobconner.blog.domain.Article
import com.jacobconner.blog.domain.User
import com.jacobconner.blog.repository.ArticleRepository
import com.jacobconner.blog.repository.UserRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {
    @Bean
    fun databaseInitializer(userRepository: UserRepository,
    articleRepository: ArticleRepository) =
        ApplicationRunner{
            val smaldini = userRepository.save(User("smaldini", "Stephane", "Maldini"))
            articleRepository.save(Article(title = "Reactor Bismuth is out",
            headline = "Lorem ipsum",
            content = " dolor sit amet",
            author = smaldini))

            articleRepository.save(
                Article(
                title = "Reactor Aluminium has landed",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
            ))
        }
}
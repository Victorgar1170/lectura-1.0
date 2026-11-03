package com.example.lectura

import androidx.lifecycle.ViewModel

data class Article(val id: Int, val title: String, val author: String, val content: String)

interface ArticleRepository {
    fun getArticles(): List<Article>
}

class ArticleViewModel(private val repository: ArticleRepository) : ViewModel() {

    var articles: List<Article> = emptyList()
        private set
    var errorMessage: String? = null
        private set

    fun loadArticles() {
        try {
            articles = repository.getArticles()
            errorMessage = null
        } catch (e: Exception) {
            articles = emptyList()
            errorMessage = "No se pudieron cargar los artículos"
        }
    }

    fun searchByTitle(query: String): List<Article> =
        articles.filter { it.title.contains(query.trim(), ignoreCase = true) }
}

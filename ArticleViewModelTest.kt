package com.example.lectura

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ArticleViewModelTest {

    // Repositorio simulado (mock) para no depender de red ni de base de datos
    private class FakeRepository(private val fail: Boolean = false) : ArticleRepository {
        override fun getArticles(): List<Article> {
            if (fail) throw RuntimeException("Sin conexión")
            return listOf(
                Article(1, "Introducción a Kotlin", "Ana", "Contenido 1"),
                Article(2, "Pruebas unitarias en Android", "Luis", "Contenido 2"),
                Article(3, "Publicar en tiendas", "Marta", "Contenido 3")
            )
        }
    }

    private lateinit var viewModel: ArticleViewModel

    @Before
    fun setUp() {
        viewModel = ArticleViewModel(FakeRepository())
    }

    @Test
    fun loadArticles_success_fillsList() {
        viewModel.loadArticles()
        assertEquals(3, viewModel.articles.size)
        assertNull(viewModel.errorMessage)
    }

    @Test
    fun loadArticles_failure_setsErrorAndEmptyList() {
        val failing = ArticleViewModel(FakeRepository(fail = true))
        failing.loadArticles()
        assertTrue(failing.articles.isEmpty())
        assertEquals("No se pudieron cargar los artículos", failing.errorMessage)
    }

    @Test
    fun searchByTitle_ignoresCaseAndSpaces() {
        viewModel.loadArticles()
        val result = viewModel.searchByTitle("  kotlin ")
        assertEquals(1, result.size)
        assertEquals("Introducción a Kotlin", result[0].title)
    }

    @Test
    fun searchByTitle_noMatch_returnsEmpty() {
        viewModel.loadArticles()
        assertTrue(viewModel.searchByTitle("flutter").isEmpty())
    }
}

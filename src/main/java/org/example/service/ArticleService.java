package org.example.service;

import org.example.dto.Article;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    // Create a new article
    public void addArticle(Article article) {
    }

    // Retrieve all articles
    public List<Article> getAllArticles() {
        return null;
    }

    // Retrieve an article by id
    public Optional<Article> getArticleById(int id) {
        return null;
    }

    // Update an article
    public boolean updateArticle(int id, Article newArticle) {
        return true;
    }

    // Delete an article by id
    public boolean deleteArticle(int id) {
        return true;
    }
}

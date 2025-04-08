package org.example.controller;

import org.example.entity.Article;
import org.example.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;


    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
        articleRepository.addArticle(article);
        return new ResponseEntity<>(article, HttpStatus.CREATED);
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleRepository.getAllArticles();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Article> getArticleById(@PathVariable String id) {
        Optional<Article> article = articleRepository.getArticleById(id);
        return article.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Article> updateArticle(@PathVariable String id, @RequestBody Article newArticle) {
        boolean updated = articleRepository.updateArticle(id, newArticle);
        if (updated) {
            return new ResponseEntity<>(newArticle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Void> deleteArticle(@PathVariable String id) {
        boolean deleted = articleRepository.deleteArticle(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

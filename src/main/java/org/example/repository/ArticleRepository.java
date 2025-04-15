package org.example.repository;

import org.example.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;
import java.util.Optional;

@Repository
public class ArticleRepository {

//    @Autowired
//    private DynamoDbEnhancedClient enhancedClient;
    @Autowired
    private DynamoDbTable<Article> articleTable;
//    = enhancedClient.table("articles", TableSchema.fromBean(Article.class));

    // Create a new article
    public void addArticle(Article article) {
        articleTable.putItem(article);
    }

    // Retrieve all articles
    public List<Article> getAllArticles() {
        return null;
    }

    // Retrieve an article by id
    public Optional<Article> getArticleById(String id) {
//        return articleTable.getItem(null);
        return null;
    }

    // Update an article
    public boolean updateArticle(String id, Article newArticle) {
        return true;
    }

    // Delete an article by id
    public boolean deleteArticle(String id) {
        return true;
    }
}

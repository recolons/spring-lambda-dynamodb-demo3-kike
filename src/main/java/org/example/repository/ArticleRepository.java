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

    @Autowired
    private DynamoDbTable<Article> articleTable;

    // Create a new article
    public void addArticle(Article article) {
        articleTable.putItem(article);
    }

    // Retrieve all articles
    public List<Article> getAllArticles() {
        return articleTable.scan().items().stream().toList();
    }

    // Retrieve an article by id
    public Optional<Article> getArticleById(String id) {
        Article article = articleTable.getItem(r -> r.key(k -> k.partitionValue(id)));
        return Optional.ofNullable(article);
    }

    // Update an article
    public boolean updateArticle(String id, Article newArticle) {
        Article existingArticle = articleTable.getItem(r -> r.key(k -> k.partitionValue(id)));
        if (existingArticle != null) {
            articleTable.putItem(newArticle);
            return true;
        }
        return false;
    }

    // Delete an article by id
    public boolean deleteArticle(String id) {
        Article article = articleTable.getItem(r -> r.key(k -> k.partitionValue(id)));
        if (article != null) {
            articleTable.deleteItem(r -> r.key(k -> k.partitionValue(id)));
            return true;
        }
        return false;
    }
}

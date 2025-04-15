package org.example.config;

import org.example.entity.Article;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDBConfig {

    Region region = Region.US_EAST_1;

    @Bean
    public DynamoDbTable<Article> articleTable() {
        return enhancedClient().table("articles", TableSchema.fromBean(Article.class));
    }

    public DynamoDbEnhancedClient enhancedClient() {
        return DynamoDbEnhancedClient.builder().dynamoDbClient(standardClient()).build();
    }

    public DynamoDbClient standardClient() {
        return DynamoDbClient.builder().credentialsProvider(ProfileCredentialsProvider.create()).region(region)
                .build();
    }
//    DynamoDbClient standardClient = DynamoDbClient.builder()
//            .region(region)
//            .credentialsProvider(ProfileCredentialsProvider.create())
//            .build();
//
//    @Bean
//    public DynamoDbEnhancedClient enhancedClient() {
//       return DynamoDbEnhancedClient.builder()
//                .dynamoDbClient(standardClient)
//                .build();


//    DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
//                .dynamoDbClient(standardClient)
//                .build();
//
//    @Bean
//    public DynamoDbTable<Article> articleTable() {
//        return enhancedClient.table("articles", TableSchema.fromBean(Article.class));
//    }
}


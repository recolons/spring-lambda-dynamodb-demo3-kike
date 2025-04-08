package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@Configuration
public class DynamoDBConfig {

    Region region = Region.US_EAST_1;

    DynamoDbClient standardClient = DynamoDbClient.builder()
            .region(region)
            .credentialsProvider(ProfileCredentialsProvider.create())
            .build();

    @Bean
    public DynamoDbEnhancedClient enhancedClient() {
       return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(standardClient)
                .build();
    }
}


package com.mango.parrot.data.config.db;

import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

@Configuration
public class MongoConfig {

    @Bean
    public MongoDbFactory mongoDbFactory(MongoDbProperties mongoDbProperties) {
        MongoClientOptions.Builder optionsBuilder = MongoClientOptions.builder();
        if (mongoDbProperties.getServerSelectionTimeout() != null) {
            optionsBuilder.serverSelectionTimeout(mongoDbProperties.getServerSelectionTimeout());
        }
        return new SimpleMongoDbFactory(new MongoClientURI(mongoDbProperties.getUri(), optionsBuilder));
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory) {
        return new MongoTemplate(mongoDbFactory);
    }

}


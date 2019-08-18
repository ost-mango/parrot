package com.mango.parrot.data.config.db;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoDbProperties {

    private String uri;

    private Integer serverSelectionTimeout;

}

package com.mango.parrot.data.config;


import com.mango.parrot.data.cache.AssociationCache;
import com.mango.parrot.data.cache.MapAssociationCache;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.apache.commons.text.similarity.CosineDistance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ApplicationConfig {

    @Bean
    public AssociationCache userAssociationCache() {
        return new MapAssociationCache(new HashMap<>());
    }

    @Bean
    public CosineDistance cosineDistance() {
        return new CosineDistance();
    }

    @Bean
    public MapperFactory mapperFactory() {
        return new DefaultMapperFactory.Builder().build();
    }

    @Bean
    public MapperFacade mapperFacade(MapperFactory mapperFactory) {
        return mapperFactory.getMapperFacade();
    }
}
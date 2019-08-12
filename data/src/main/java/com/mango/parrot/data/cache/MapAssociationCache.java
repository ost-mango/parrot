package com.mango.parrot.data.cache;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@AllArgsConstructor
public class MapAssociationCache implements AssociationCache {

    private final Map<String, Map<String, String>> userAssociationCache;

    @Override
    public Map<String, String> getAssociationsByUserId(String id) {
        return userAssociationCache.get(id);
    }

    @Override
    public void putAssociation(String userId, Map<String, String> associationByKey) {
        userAssociationCache.put(userId, associationByKey);
    }

    @Override
    public void deleteAssociation(String userId) {
        userAssociationCache.remove(userId);
    }
}

package com.mango.parrot.data.service.cache;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserAssociationCache {

    private final Map<String, Map<String, String>> userAssociationCache;

    public UserAssociationCache() {
        this.userAssociationCache = new HashMap<>();
    }

    public Map<String, String> getAssociationsByUserId(String id) {
        return userAssociationCache.get(id);
    }

    public void putUserAssociation(String userId, Map<String, String> associationByKey) {
        userAssociationCache.put(userId, associationByKey);
    }

    public void deleteUserAssociation(String userId) {
        userAssociationCache.remove(userId);
    }
}

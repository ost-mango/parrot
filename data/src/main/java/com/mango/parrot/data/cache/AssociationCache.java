package com.mango.parrot.data.cache;

import java.util.Map;

public interface AssociationCache {

    Map<String, String> getAssociationsByUserId(String id);

    void putAssociation(String userId, Map<String, String> associationByKey);

    void deleteAssociation(String userId);
}

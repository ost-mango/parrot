package com.mango.parrot.data.search;

import java.util.Map;

public interface AssociationSearcher {

    Map<String, String> getMostSimilarAssociation(String key, Map<String, String> associationByKey);

    Map<String, String> getMostSimilarAssociation(String key, Map<String, String> associationByKey, Integer count);
}

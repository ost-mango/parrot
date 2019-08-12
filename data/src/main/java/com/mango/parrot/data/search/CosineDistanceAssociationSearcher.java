package com.mango.parrot.data.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.text.similarity.CosineDistance;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CosineDistanceAssociationSearcher implements AssociationSearcher {

    private CosineDistance cosineDistance;

    @Override
    public Map<String, String> getMostSimilarAssociation(String key, Map<String, String> associationByKey) {
        String mostSimilarAssociation = associationByKey.keySet().stream().map(k -> new SimilarityResult(k, cosineDistance.apply(k, key)))
                .sorted(Comparator.comparing(SimilarityResult::getResult))
                .map(SimilarityResult::getKey)
                .collect(Collectors.toList())
                .get(0);
        return Collections.singletonMap(mostSimilarAssociation, associationByKey.get(mostSimilarAssociation));
    }

    @Override
    public Map<String, String> getMostSimilarAssociation(String key, Map<String, String> associationByKey, Integer count) {
        return null;
    }


    @AllArgsConstructor
    @Getter
    private class SimilarityResult {

        private String key;
        private Double result;
    }

}

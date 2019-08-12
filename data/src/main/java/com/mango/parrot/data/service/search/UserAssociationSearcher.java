package com.mango.parrot.data.service.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.text.similarity.CosineDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserAssociationSearcher {

    @Autowired
    private CosineDistance cosineDistance;

    public List<String> getMostSimilarKeys(String key, Set<String> setKeys, Integer count) {
        List<String> list = setKeys.stream().map(k -> new SimilarityResult(k, cosineDistance.apply(k, key)))
                .sorted(Comparator.comparing(SimilarityResult::getResult))
                .map(SimilarityResult::getKey)
                .collect(Collectors.toList());
        return list.subList(0, count);
    }


    @AllArgsConstructor
    @Getter
    private class SimilarityResult {

        private String key;
        private Double result;
    }

}

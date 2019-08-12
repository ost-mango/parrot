package com.mango.parrot.data.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = Association.COLLECTION_NAME)
public class Association {
    public final static String COLLECTION_NAME = "Association";

    @Id
    private String userId;

    private Map<String, String> associationByKey;

}

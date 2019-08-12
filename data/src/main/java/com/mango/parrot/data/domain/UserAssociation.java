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
@Document(collection = UserAssociation.COLLECTION_NAME)
public class UserAssociation {
    public final static String COLLECTION_NAME = "UserAssociation";

    @Id
    private String userId;

    private Map<String, String> associationByKey;

}

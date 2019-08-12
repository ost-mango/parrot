package com.mango.parrot.data.service;

import com.mango.parrot.data.dto.AssociationDto;

import java.util.Map;

public interface AssociationService {

    AssociationDto createUserAssociation(AssociationDto associationDto);

    AssociationDto updateUserAssociation(AssociationDto associationDto);

    Map<String, String> getUserAssociation(String userId, String key, Integer count);

    AssociationDto cacheUserAssociation(String userId);

    void uncacheUserAssociation(String userId);
}

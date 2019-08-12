package com.mango.parrot.data.service;

import com.mango.parrot.data.cache.AssociationCache;
import com.mango.parrot.data.domain.Association;
import com.mango.parrot.data.dto.AssociationDto;
import com.mango.parrot.data.repository.AssociationRepository;
import com.mango.parrot.data.search.AssociationSearcher;
import lombok.AllArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@AllArgsConstructor
public class MongoAssociationService implements AssociationService {

    private final AssociationRepository associationRepository;
    private final AssociationCache associationCache;
    private final AssociationSearcher associationSearcher;
    private final MapperFacade mapperFacade;

    @Transactional
    public AssociationDto createUserAssociation(AssociationDto associationDto) {
        if (!associationRepository.existsById(associationDto.getUserId())) {
            Association saved = associationRepository.save(mapperFacade.map(associationDto, Association.class));
            return mapperFacade.map(saved, AssociationDto.class);
        } else
            throw new EntityExistsException("User with id: " + associationDto.getUserId() + " already exist");
    }

    @Override
    @Transactional
    public AssociationDto updateUserAssociation(AssociationDto associationDto) {
        Association association = associationRepository.findById(associationDto.getUserId())
                .orElseThrow(() -> new NoSuchElementException("User with id: " + associationDto.getUserId() + " does not exist"));
        association.getAssociationByKey().putAll(associationDto.getAssociationByKey());
        Association saved = associationRepository.save(association);
        return mapperFacade.map(saved, AssociationDto.class);
    }

    @Override
    public Map<String, String> getUserAssociation(String userId, String key, Integer count) {
        Map<String, String> map = Optional.ofNullable(associationCache.getAssociationsByUserId(userId))
                .orElseGet(() -> cacheUserAssociation(userId).getAssociationByKey());
        return associationSearcher.getMostSimilarAssociation(key, map);
    }


    @Override
    public AssociationDto cacheUserAssociation(String userId) {
        Association association = associationRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User with id: " + userId + " does not exist"));
        associationCache.putAssociation(association.getUserId(), association.getAssociationByKey());
        return mapperFacade.map(association, AssociationDto.class);
    }

    @Override
    public void uncacheUserAssociation(String userId) {
        associationCache.deleteAssociation(userId);
    }
}

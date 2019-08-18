package com.mango.parrot.data.service;

import com.mango.parrot.data.domain.UserAssociation;
import com.mango.parrot.data.dto.UserAssociationDto;
import com.mango.parrot.data.repository.UserAssociationRepository;
import com.mango.parrot.data.service.cache.UserAssociationCache;
import com.mango.parrot.data.service.search.UserAssociationSearcher;
import lombok.AllArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserAssociationService {

    private final UserAssociationRepository userAssociationRepository;
    private final UserAssociationCache userAssociationCache;
    private final UserAssociationSearcher userAssociationSearcher;
    private final MapperFacade mapperFacade;

    @Transactional
    public UserAssociationDto createUserAssociation(UserAssociationDto userAssociationDto) {
        if (!userAssociationRepository.existsById(userAssociationDto.getUserId())) {
            UserAssociation saved = userAssociationRepository.save(mapperFacade.map(userAssociationDto, UserAssociation.class));
            return mapperFacade.map(saved, UserAssociationDto.class);
        } else
            throw new EntityExistsException("User with id: " + userAssociationDto.getUserId() + " already exist");
    }

    @Transactional
    public UserAssociationDto updateUserAssociation(UserAssociationDto userAssociationDto) {
        UserAssociation userAssociation = userAssociationRepository.findById(userAssociationDto.getUserId())
                .orElseThrow(() -> new NoSuchElementException("User with id: " + userAssociationDto.getUserId() + " does not exist"));
        userAssociation.getAssociationByKey().putAll(userAssociationDto.getAssociationByKey());
        UserAssociation saved = userAssociationRepository.save(userAssociation);
        return mapperFacade.map(saved, UserAssociationDto.class);
    }

    public List<String> getUserAssociation(String userId, String key, Integer count) {
        Map<String, String> map = Optional.of(userAssociationCache.getAssociationsByUserId(userId))
                .orElseGet(() -> cacheUserAssociation(userId).getAssociationByKey());
        return userAssociationSearcher.getMostSimilarKeys(key, map.keySet(), count);
    }


    public UserAssociationDto cacheUserAssociation(String userId) {
        UserAssociation userAssociation = userAssociationRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User with id: " + userId + " does not exist"));
        userAssociationCache.putUserAssociation(userAssociation.getUserId(), userAssociation.getAssociationByKey());
        return mapperFacade.map(userAssociation, UserAssociationDto.class);
    }

    public void uncacheUserAssociation(String userId) {
        userAssociationCache.deleteUserAssociation(userId);
    }
}

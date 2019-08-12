package com.mango.parrot.data.repository;

import com.mango.parrot.data.domain.UserAssociation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserAssociationRepository extends MongoRepository<UserAssociation, String> {
}

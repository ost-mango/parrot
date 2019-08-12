package com.mango.parrot.data.repository;

import com.mango.parrot.data.domain.Association;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssociationRepository extends MongoRepository<Association, String> {
}

package com.spring.lofilive.repository;

import com.spring.lofilive.document.LofiDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LofiRepository extends MongoRepository<LofiDocument, String> {
}

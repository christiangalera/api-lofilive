package com.spring.lofilive.repository;

import com.spring.lofilive.document.LofiDocument;
import com.spring.lofilive.enums.VideoStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LofiRepository extends MongoRepository<LofiDocument, String> {
    Page<LofiDocument> findByVideoStatus(VideoStatus status, Pageable pageable);
}

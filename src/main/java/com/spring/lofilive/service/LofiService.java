package com.spring.lofilive.service;

import com.spring.lofilive.document.LofiDocument;
import com.spring.lofilive.repository.LofiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LofiService {

    @Autowired
    LofiRepository lofiRepository;

    public List<LofiDocument> findAll() {
        return lofiRepository.findAll();
    }

    public Optional<LofiDocument> findById(String id){
        return lofiRepository.findById(id);
    }

    public LofiDocument save(LofiDocument lofiDocument){
        return lofiRepository.save(lofiDocument);
    }

    public void delete(LofiDocument lofiDocument){
        lofiRepository.delete(lofiDocument);
    }

}

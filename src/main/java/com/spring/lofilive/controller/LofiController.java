package com.spring.lofilive.controller;

import com.spring.lofilive.document.LofiDocument;
import com.spring.lofilive.enums.VideoStatus;
import com.spring.lofilive.service.LofiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
public class LofiController {

    @Autowired
    LofiService lofiService;

    @GetMapping("/lofilives")
    public ResponseEntity<Page<LofiDocument>> getAllLofi(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
            @RequestParam(required = false) String flag){
        Page<LofiDocument> lofiPage = lofiService.findAll(pageable, flag);
        if(lofiPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Page<LofiDocument>>(lofiPage,HttpStatus.OK);
        }
    }

    @GetMapping("/lofilives/{id}")
    public ResponseEntity<LofiDocument> getOneLofi(@PathVariable(value="id") String id){
        Optional<LofiDocument> lofiOptional = lofiService.findById(id);
        if(!lofiOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<LofiDocument>(lofiOptional.get(), HttpStatus.OK);
        }
    }

    @PostMapping("/lofilives")
    public ResponseEntity<LofiDocument> saveLofi(@RequestBody @Valid LofiDocument lofi){
        lofi.setRegistrationDate(LocalDateTime.now());
        return new ResponseEntity<LofiDocument>(lofiService.save(lofi), HttpStatus.CREATED);
    }

    @DeleteMapping("/lofilives/{id}")
    public ResponseEntity<?> deleteLofi(@PathVariable(value="id") String id) {
        Optional<LofiDocument> lofiOptional = lofiService.findById(id);
        if(!lofiOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            // t
            lofiService.delete(lofiOptional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping("/lofilives/{id}")
    public ResponseEntity<LofiDocument> updateLofi(@PathVariable(value="id") String id,
                                                   @RequestBody @Valid LofiDocument lofiDocument) {
        Optional<LofiDocument> lofiOptional = lofiService.findById(id);
        if(!lofiOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            lofiDocument.setId(lofiOptional.get().getId());
            return new ResponseEntity<LofiDocument>(lofiService.save(lofiDocument), HttpStatus.OK);
        }
    }

}

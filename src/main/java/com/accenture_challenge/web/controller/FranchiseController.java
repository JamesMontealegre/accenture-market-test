package com.accenture_challenge.web.controller;

import com.accenture_challenge.domain.dto.FranchiseDTO;
import com.accenture_challenge.domain.repository.FranchiseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/franchises")
public class FranchiseController {

    private final FranchiseRepository franchiseRepository;

    public FranchiseController(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    @PostMapping
    public ResponseEntity<FranchiseDTO> addFranchise(@RequestBody FranchiseDTO franchiseDTO) {
        FranchiseDTO createdFranchise = franchiseRepository.addFranchise(franchiseDTO);
        return ResponseEntity.ok(createdFranchise);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FranchiseDTO> getFranchiseById(@PathVariable Long id) {
        Optional<FranchiseDTO> franchiseDTO = franchiseRepository.findById(id);
        return franchiseDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<FranchiseDTO>> getAllFranchises() {
        return ResponseEntity.ok(franchiseRepository.getAllFranchises());
    }
}

package com.accenture_challenge.web.controller;

import com.accenture_challenge.domain.dto.BranchDTO;
import com.accenture_challenge.domain.repository.BranchRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branches")
public class BranchController {

    private final BranchRepository branchRepository;

    public BranchController(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @PostMapping("/{franchiseId}")
    public ResponseEntity<BranchDTO> addBranchToFranchise(
            @PathVariable Long franchiseId,
            @RequestBody BranchDTO branchDTO) {
        BranchDTO createdBranch = branchRepository.addBranchToFranchise(franchiseId, branchDTO);
        return ResponseEntity.ok(createdBranch);
    }

    @GetMapping("/franchise/{franchiseId}")
    public ResponseEntity<List<BranchDTO>> getBranchesByFranchise(@PathVariable Long franchiseId) {
        List<BranchDTO> branches = branchRepository.getBranchesByFranchise(franchiseId);
        return ResponseEntity.ok(branches);
    }
}

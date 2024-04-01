package com.example.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Beneficiary;
//import com.example.model.Document;
import com.example.repository.BeneficiaryRepository;
import com.example.repository.DocumentRepository;
import com.example.service.BeneficiaryService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;
//import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/beneficiary/api/v2")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService benService;
    

    @PostMapping("/beneficiarycreate")
    public Beneficiary saveBeneficiary(@RequestBody @Valid Beneficiary benArg) {
        return benService.saveBeneficiary(benArg);
    }

    @GetMapping("/beneficiariesall")
    public List<Beneficiary> fetchAllBeneficiaries() {
        return benService.fetchAllBeneficiaries();
    }

    @GetMapping("/benbyid/{id}")
    public Beneficiary getBenById(@PathVariable("id") Long id) {
        return benService.getBeneficiaryById(id);
    }

    @PutMapping("/benupdate/{id}")
    public Beneficiary updateBen(@PathVariable("id") Long id, @RequestBody @Valid Beneficiary b) {
        return benService.updateBeneficiaryById(id, b);
    }

    @DeleteMapping("/bendel/{id}")
    public String deleteBen(@PathVariable("id") Long id) {
        return benService.deletBeneficiaryById(id);
    }


}

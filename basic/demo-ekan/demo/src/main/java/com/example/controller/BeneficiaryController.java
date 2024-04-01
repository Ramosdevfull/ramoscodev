package com.example.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Beneficiary;
//import com.example.model.Document;
import com.example.repository.BeneficiaryRepository;
import com.example.repository.DocumentRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;
//import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/beneficiary/api/v1")
public class BeneficiaryController {
    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @Autowired
    private DocumentRepository documentRepository;

    

    @GetMapping("/all")
    public List<Beneficiary> getAllBeneficiaries() {
        /*Beneficiary beneOptional = (Beneficiary) beneficiaryRepository.findAll();
        if (beneOptional.getId() != 0) {
            List<Document> docsBen = documentRepository.findAll().
            //beneOptional.setChildDocuments(null);
        }
        */
        return beneficiaryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Beneficiary> getBeneficiaryById(@PathVariable("id") Long id) {
        return beneficiaryRepository.findById(id);
    }

    @PostMapping("/create")
    public Beneficiary create(@RequestBody @Valid Beneficiary entity) {

        return beneficiaryRepository.save(entity);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<Beneficiary> update(@PathVariable Long id, @Valid @RequestBody Beneficiary e) {
        Beneficiary ben1 = beneficiaryRepository.findById(id)
                                            .orElseThrow(() -> new ResourceNotFoundException("Beneficiary not exist with ID" + id));

        if ((ben1.getId() > 0) && (!ben1.getChildDocuments().isEmpty())) {

                ben1.setId(e.getId());
                ben1.setName(e.getName());
                ben1.setBirth(e.getBirth());
                ben1.setMobile(e.getMobile());
                ben1.setDtstore(e.getDtstore());
                ben1.setDtupdate(e.getDtupdate());
                ben1.setChildDocuments(e.getChildDocuments());
                
                /*
                Beneficiary entity = ben1.get();

            if (Objects.nonNull(e.getMobile()) && !"".equalsIgnoreCase(e.getMobile())) {
                entity.setMobile(e.getMobile());
            }
            if (Objects.nonNull(e.getName()) && !"".equalsIgnoreCase(e.getName())) {
                entity.setName(e.getName());
            }
            //return //beneficiaryRepository.save(entity);
                */
                
        }
        Beneficiary entity = beneficiaryRepository.updateCustom(ben1);
  
        return ResponseEntity.ok(entity);
    }


    
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        String msg = "Beneficiary not found!";
        if (beneficiaryRepository.findById(id).isPresent()) {
            beneficiaryRepository.deleteById(id);
            msg = "Beneficiary deleted with  successfully!";
        }
        return msg;
    }

    @PutMapping("updatedata/{id}")
    public ResponseEntity<Beneficiary> updateDataBeneficiary(@PathVariable Long id, @Valid @RequestBody Beneficiary entityDetails) 
    throws ResourceNotFoundException {
        Beneficiary ben = beneficiaryRepository.findById(id)
                                .orElseThrow(() ->  new ResourceNotFoundException("ResourceNotFoundException - updateDataBeneficiary"));
        ben.setId(entityDetails.getId());
        ben.setName(entityDetails.getName());
        ben.setBirth(entityDetails.getBirth());
        ben.setMobile(entityDetails.getMobile());
        ben.setDtstore(entityDetails.getDtstore());
        ben.setDtupdate(entityDetails.getDtupdate());
        ben.setChildDocuments(entityDetails.getChildDocuments());

        final Beneficiary updateBen = beneficiaryRepository.save(ben);

        return ResponseEntity.ok(updateBen);
    }

    @Transactional
    @PutMapping("updatedatax/{id}")
    public Beneficiary updateDataAnyProperties(@PathVariable Long id, @Valid @RequestBody Beneficiary entityArgs) {
        Beneficiary ben = beneficiaryRepository.findById(id)
                                .orElseThrow(() ->  new ResourceNotFoundException("ResourceNotFoundException - updateDataBeneficiary"));
        //ben.setId(entityArgs.getId());
        ben.setName(entityArgs.getName());
        ben.setBirth(entityArgs.getBirth());
        ben.setMobile(entityArgs.getMobile());
        ben.setDtstore(entityArgs.getDtstore());
        ben.setDtupdate(entityArgs.getDtupdate());
        ben.setChildDocuments(entityArgs.getChildDocuments());
        beneficiaryRepository.save(ben);
        return ben;
    }


}

package com.example.service;

import java.util.ArrayList;
import java.util.function.Consumer;

import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exception.ResourceNotFoundException;
import com.example.model.Beneficiary;
import com.example.model.Document;
import com.example.repository.BeneficiaryRepository;
import com.example.repository.DocumentRepository;

@Service
@Transactional
public class BeneficiaryService {
    private BeneficiaryRepository beneficiaryRepository = null;
    private DocumentRepository documentRepository = null;

    public BeneficiaryService(BeneficiaryRepository benRepo, DocumentRepository docRepo){
        this.beneficiaryRepository = benRepo;
        this.documentRepository = docRepo;
    }

    public void updateBenDoc(Long benId, Beneficiary newBen) {

        Beneficiary b = this.beneficiaryRepository.findById(benId).orElseThrow(() -> new ResourceNotFoundException("xxxx"));
        
        b.setId(newBen.getId());
        b.setName(newBen.getName());
        b.setBirth(newBen.getBirth());
        b.setMobile(newBen.getMobile());
        b.setDtstore(newBen.getDtstore());
        b.setDtupdate(newBen.getDtupdate());
        b.setChildDocuments(newBen.getChildDocuments());
        if(!newBen.getChildDocuments().isEmpty()) {
            //for (int i = 0; i < newBen.getChildDocuments().size(); i++) {
                b.setChildDocuments(newBen.getChildDocuments());
            //}
            
        }
        beneficiaryRepository.save(b);
    }
}

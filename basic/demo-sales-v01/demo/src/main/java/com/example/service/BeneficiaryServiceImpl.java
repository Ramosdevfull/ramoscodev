package com.example.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Beneficiary;
import com.example.repository.BeneficiaryRepository;

@Service
public class BeneficiaryServiceImpl implements BeneficiaryService {

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

    @Override
    public Beneficiary saveBeneficiary(Beneficiary beneficiary) {
        return beneficiaryRepository.save(beneficiary);
    }

    @Override
    public List<Beneficiary> fetchAllBeneficiaries() {
        List<Beneficiary> allBeneficiaries = beneficiaryRepository.findAll();
        return allBeneficiaries;
    }

    @Override
    public Beneficiary getBeneficiaryById(Long id) {
        Optional<Beneficiary> benOptional = beneficiaryRepository.findById(id);
        if (benOptional.isPresent()) {
            return benOptional.get();
        }
        return null;
    }

    @Override
    public Beneficiary updateBeneficiaryById(Long id, Beneficiary beneficiary) {
        Optional<Beneficiary> benOptional = beneficiaryRepository.findById(id);
        if (benOptional.isPresent()) {
            Beneficiary benFindByDB = benOptional.get();

            if (Objects.nonNull(beneficiary.getName()) && !"".equalsIgnoreCase(beneficiary.getName())) {
                benFindByDB.setName(beneficiary.getName());
            }
            if (Objects.nonNull(beneficiary.getMobile()) && !"".equalsIgnoreCase(beneficiary.getMobile())) {
                benFindByDB.setMobile(beneficiary.getMobile());
            }
            return beneficiaryRepository.save(benFindByDB);
        }
        return null;
    }

    @Override
    public String deletBeneficiaryById(Long id) {
        if (beneficiaryRepository.findById(id).isPresent()) {
            beneficiaryRepository.deleteById(id);
            return "Beneficiary deleted sucessfully";
        }
        return "Beneficiary not found!";
    }
    
}

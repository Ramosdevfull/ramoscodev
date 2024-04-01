package com.example.service;

import com.example.model.Beneficiary;

public interface BeneficiaryService {

    Beneficiary saveBeneficiary(Beneficiary beneficiary);

    java.util.List<Beneficiary> fetchAllBeneficiaries();

    Beneficiary getBeneficiaryById(Long id);

    Beneficiary updateBeneficiaryById(Long id, Beneficiary beneficiary);

    String deletBeneficiaryById(Long id);

} 
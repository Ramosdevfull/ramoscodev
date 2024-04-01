package com.example.repository;

import com.example.model.Beneficiary;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CustomUpdateRepositoryImpl implements CustomUpdateRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Beneficiary updateCustom(Beneficiary b) {
        if (b.getId() > 0) {
            entityManager.merge(b);
        }
        throw new UnsupportedOperationException("Unimplemented method 'updateCustom'");
    }
}

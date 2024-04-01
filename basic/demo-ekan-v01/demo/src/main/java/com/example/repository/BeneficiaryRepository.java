package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Beneficiary;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long>, CustomUpdateRepository {
    /*
    @Modifying
    @Query("update beneficiary b set b.name = :newName, b.birth = newBirth, b.mobile = newMobile, b.dtlastmodified =  where u.id = :benId")
    void updateBeneficiaryQuery(@Param("benId") Long benId, 
        @Param("newName") String newName, 
        @Param("newMobile") String newMobile,
        @Param("newBirth") String newBirth,
        @Param("newDtupdate") String newDtupdate);
        */
}


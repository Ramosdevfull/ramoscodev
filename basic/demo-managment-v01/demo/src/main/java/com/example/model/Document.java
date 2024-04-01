package com.example.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@JsonIgnoreProperties({ "beneficiary" })
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoDoc;
    private String descricao;
    @CreatedDate
    @Column(name = "dtstore")
    private Date dtstore;
    @LastModifiedDate
    @Column(name = "dtlastmodified")
    private Date dtupdate;

    //@JsonBackReference
    //@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JoinColumn(name = "beneficiary_id")
    @JsonBackReference
	//@ManyToOne
	//@JoinColumn(name = "beneficiary_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "beneficiary_id")
    Beneficiary beneficiary;

    public Document() {}

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the tipoDoc
     */
    public String getTipoDoc() {
        return tipoDoc;
    }

    /**
     * @param tipoDoc the tipoDoc to set
     */
    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    /**
     * @return String return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return Date return the dtstore
     */
    public Date getDtstore() {
        return dtstore;
    }

    /**
     * @param dtstore the dtstore to set
     */
    public void setDtstore(Date dtstore) {
        this.dtstore = dtstore;
    }

    /**
     * @return Date return the dtupdate
     */
    public Date getDtupdate() {
        return dtupdate;
    }

    /**
     * @param dtupdate the dtupdate to set
     */
    public void setDtupdate(Date dtupdate) {
        this.dtupdate = dtupdate;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

}

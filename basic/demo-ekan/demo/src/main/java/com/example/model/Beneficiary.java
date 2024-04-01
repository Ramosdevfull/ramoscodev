package com.example.model;

//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    @Column(name="telefone",length=9,nullable=false)
    private String mobile;
    @CreatedDate
    @Column(name = "dtbirth")
    private Date birth;
    @CreatedDate
    @Column(name = "dtstore")
    private Date dtstore;
    @LastModifiedDate
    @Column(name = "dtlastmodified")
    private Date dtupdate;

    //@OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL)
	//@JoinColumn(name = "beneficiary_id")
	@JsonManagedReference
	//private Set<Document> doc;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "beneficiary", cascade = CascadeType.ALL)
    private List<Document> childDocuments = new ArrayList<>();



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
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return Date return the birth
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * @param birth the birth to set
     */
    public void setBirth(Date birth) {
        this.birth = birth;
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

    public void setChildDocuments(List<Document> childDocuments) {
        this.childDocuments = childDocuments;
    }

    public List<Document> getChildDocuments() {
        return childDocuments;
    }
    
}

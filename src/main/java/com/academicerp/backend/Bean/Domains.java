package com.academicerp.backend.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Domains")
public class Domains {

    public Domains(){}

    public Integer getDomainId() {
        return domainId;
    }

    public Domains(Integer domainId, String program, String batch, Integer capacity, String qualification) {
        this.domainId = domainId;
        this.program = program;
        this.batch = batch;
        this.capacity = capacity;
        this.qualification = qualification;
    }

    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer domainId;

    @Column(nullable = false)
    String program;

    @Column(nullable = false)
    String batch;

    @Column(nullable = false)
    Integer capacity;

    @Column
    String qualification;

    public Integer getDomain_id() {
        return domainId;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getQualification() {
        return qualification;
    }

    @Override
    public String toString() {
        return "{" +
                "domainId : " + domainId +
                ", program:\"" + program + '"' +
                ", batch:\"" + batch + '"' +
                ", capacity:" + capacity +
                ", qualification:\"" + qualification + '"' +
                '}';
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }


}

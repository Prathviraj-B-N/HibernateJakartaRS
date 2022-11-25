package com.academicerp.backend.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Domains")
public class Domains {

    public Domains(){}

    public Domains(String program, String batch, String capacity, String qualification) {
        this.program = program;
        this.batch = batch;
        this.capacity = capacity;
        this.qualification = qualification;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer domainId;

    @Column(nullable = false)
    String program;

    @Column(nullable = false)
    String batch;

    @Column(nullable = false)
    String capacity;

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

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }


}

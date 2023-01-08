package com.academicerp.backend.Bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Admin")
public class Admin {

    public Admin(){}

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Admin(Integer adminId, String username, String password) {
        this.adminId = adminId;
        this.username = username;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    public Integer getAdminId() {
        return adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

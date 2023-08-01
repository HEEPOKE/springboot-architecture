package com.heepoke.app.domain.models;

import java.sql.Timestamp;
import jakarta.persistence.*;

@Entity
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = "username"),
    @UniqueConstraint(columnNames = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = true)
    private String password;

    @Column(nullable = false)
    private String tel;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @Column(nullable = false)
    private Timestamp updatedAt;

    public User() {
    }

    public User(String username, String email, String password, String tel, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.tel = tel;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }  

    public String getEmail() {
        return email;
    } 

    public String getTel() {
        return tel;
    }

    public String getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setResetPassword(String password) {
        this.password = password;
    }
}

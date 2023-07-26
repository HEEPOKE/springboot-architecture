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
        setCreatedAt();
    }

    public void setCreatedAt() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.updatedAt = this.createdAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = new Timestamp(System.currentTimeMillis());
    }

    public User(String username, String email, String password, String tel, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.tel = tel;
        this.role = role;
    }

    public void setResetPassword(String password) {
        this.password = password;
    }
}

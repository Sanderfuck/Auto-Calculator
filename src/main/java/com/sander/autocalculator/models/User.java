package com.sander.autocalculator.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String phoneNumber;
    private String password;

    @Transient
    private String confirmPassword;

    @OneToMany(mappedBy = "user")
    private Set<CalculationData> calculationDataSet;

    @ManyToMany
    private Set<Role> roles;

    public User() {
    }

    public User(String email, String phoneNumber, String password) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

}

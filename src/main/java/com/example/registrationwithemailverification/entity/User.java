package com.example.registrationwithemailverification.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String userName;

    private String userEmail;

    private String userPassword;

    private boolean isEnabled;

    @OneToOne(mappedBy = "user")
    private ConfirmationToken confirmationToken;


}

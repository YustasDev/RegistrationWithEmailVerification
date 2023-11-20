package com.example.registrationwithemailverification.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "confirmationToken")
public class ConfirmationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="token_id")
    private Long tokenId;

    @Column(name="confirmation_token")
    private String confirmationToken;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    @ToString.Exclude
    private User user;


    public ConfirmationToken(String confirmationToken) {
        this.tokenId = tokenId;
        this.confirmationToken = UUID.randomUUID().toString();
        this.createdDate = createdDate;
    }


}

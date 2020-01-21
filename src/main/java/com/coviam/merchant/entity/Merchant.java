package com.coviam.merchant.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "merch_table")
public class Merchant {

    @Id
    private String merchEmail;
    private String merchPassword;
    private String merchName;
    private String merchAddress;
    private String merchImgUrl;
   // private String merchLastLogin;

}

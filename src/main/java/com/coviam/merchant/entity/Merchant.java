package com.coviam.merchant.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
public class Merchant {

    @Id
    private String merchantEmail;
    private String merchantPassword;
    private String merchantName;
    private String merchantAddress;
    private String merchantImgUrl;
    private String merchantLastLogin;

}

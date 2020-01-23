package com.coviam.merchant.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDetailsDTO {
    String uuid;
    private String merchantName;
    private String merchantImgUrl;
    private boolean loginStatus;

}

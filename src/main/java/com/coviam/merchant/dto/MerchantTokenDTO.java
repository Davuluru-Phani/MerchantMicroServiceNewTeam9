package com.coviam.merchant.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MerchantTokenDTO {
    private String uuid;
    private String merchantEmail;
}

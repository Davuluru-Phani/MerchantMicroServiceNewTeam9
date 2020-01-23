package com.coviam.merchant.services;

import com.coviam.merchant.dto.LoginDetailsDTO;
import com.coviam.merchant.dto.MerchantLoginDTO;
import com.coviam.merchant.entity.Merchant;

public interface MerchantServices {
    public Merchant save(Merchant merchant);
    public String getPass(String email);

    LoginDetailsDTO checkLoginDetails(MerchantLoginDTO userLogin);

    String getName(String merchanId);
}

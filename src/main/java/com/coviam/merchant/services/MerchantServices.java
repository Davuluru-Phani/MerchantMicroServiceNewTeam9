package com.coviam.merchant.services;

import com.coviam.merchant.entity.Merchant;

public interface MerchantServices {
    public Merchant save(Merchant merch);
    public String getPass(String email);
}

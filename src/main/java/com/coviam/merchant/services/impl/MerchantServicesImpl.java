package com.coviam.merchant.services.impl;

import com.coviam.merchant.entity.Merchant;
import com.coviam.merchant.repository.MerchantRepo;
import com.coviam.merchant.services.MerchantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServicesImpl implements MerchantServices {
    @Autowired
    MerchantRepo merchRepo;

    public Merchant save(Merchant merch) { return merchRepo.save(merch); }

    public String getPass(String email){
        return merchRepo.findById(email).get().getMerchPassword();
    }
}

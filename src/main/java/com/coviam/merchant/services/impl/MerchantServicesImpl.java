package com.coviam.merchant.services.impl;

import com.coviam.merchant.dto.LoginDetailsDTO;
import com.coviam.merchant.dto.MerchantLoginDTO;
import com.coviam.merchant.entity.Merchant;
import com.coviam.merchant.entity.MerchantToken;
import com.coviam.merchant.repository.MerchantRepo;
import com.coviam.merchant.repository.MerchantTokenRepo;
import com.coviam.merchant.services.MerchantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MerchantServicesImpl implements MerchantServices {
    @Autowired
    MerchantRepo merchRepo;
    @Autowired
    MerchantTokenRepo merchantTokenRepo;

    public Merchant save(Merchant merchant) {
        return merchRepo.save(merchant);
    }

    public String getPass(String email) {
        return merchRepo.findById(email).get().getMerchantPassword();
    }

    @Override
    public LoginDetailsDTO checkLoginDetails(MerchantLoginDTO merchantLoginDTO) {
        System.out.println("************>" + merchantLoginDTO.getMerchantEmail());
        Optional<Merchant> user1 = merchRepo.findById(merchantLoginDTO.getMerchantEmail());
        LoginDetailsDTO loginDetailsDTO = new LoginDetailsDTO();
        if (user1.isPresent() && user1.get().getMerchantPassword().equals(merchantLoginDTO.getMerchantPassword())) {
            System.out.println("user1 :" + user1.toString());
            UUID uuid = UUID.randomUUID();
            MerchantToken merchantToken = new MerchantToken();
            merchantToken.setUuid(uuid.toString());
            merchantToken.setMerchantEmail(merchantLoginDTO.getMerchantEmail());
            merchantTokenRepo.save(merchantToken);
            Merchant user = merchRepo.findByMerchantEmail(merchantLoginDTO.getMerchantEmail());
            loginDetailsDTO.setLoginStatus(true);
            loginDetailsDTO.setMerchantName(user.getMerchantName());
            loginDetailsDTO.setUuid(uuid.toString());
            loginDetailsDTO.setMerchantImgUrl(user.getMerchantImgUrl());
            return loginDetailsDTO;
        }
        loginDetailsDTO.setMerchantImgUrl("");
        loginDetailsDTO.setUuid("");
        loginDetailsDTO.setMerchantName("");
        loginDetailsDTO.setLoginStatus(false);
        return loginDetailsDTO;
    }

    @Override
    public String getName(String merchanId) {
        final Optional<Merchant> byId = merchRepo.findById(merchanId);
        String merchantName = null;
        if (byId.isPresent()) {
            merchantName = byId.get().getMerchantName();
        }
        return merchantName;
    }
}


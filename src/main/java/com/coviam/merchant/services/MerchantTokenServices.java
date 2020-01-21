package com.coviam.merchant.services;

import com.coviam.merchant.entity.MerchantToken;

import java.util.Optional;

public interface MerchantTokenServices {
    public MerchantToken generateUuid(String email);
    public Optional<MerchantToken> checkUuid(String uuid);
    public boolean deleteUuid(String uuid);
}

package com.coviam.merchant.repository;

import com.coviam.merchant.entity.MerchantToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantTokenRepo extends CrudRepository<MerchantToken,String> {
}

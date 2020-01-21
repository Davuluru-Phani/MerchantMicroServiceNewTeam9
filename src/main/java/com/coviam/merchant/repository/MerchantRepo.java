package com.coviam.merchant.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coviam.merchant.entity.Merchant;

@Repository
public interface MerchantRepo extends CrudRepository<Merchant,String> {



}

package com.coviam.merchant.controller;

import com.coviam.merchant.dto.*;
import com.coviam.merchant.entity.Merchant;
import com.coviam.merchant.entity.MerchantToken;
import com.coviam.merchant.services.MerchantServices;
import com.coviam.merchant.services.MerchantTokenServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    MerchantServices merchServices;

    @Autowired
    MerchantTokenServices merchantTokenServices;

    @RequestMapping(method = RequestMethod.POST, value = "/addProfile")
    public ResponseEntity<StatusDTO> addUser(@RequestBody MerchantDTO merchDTO) {
        Merchant merchant = new Merchant();
        BeanUtils.copyProperties(merchDTO, merchant);
        Merchant merchCreated = merchServices.save(merchant);
        if (merchCreated != null) {
            return new ResponseEntity<StatusDTO>(new StatusDTO(true), HttpStatus.OK);
        }
        return new ResponseEntity<StatusDTO>(new StatusDTO(false), HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/edit")
    public ResponseEntity<Boolean> editUser(@RequestBody MerchantDTO merchDTO) {
        System.out.println(merchDTO);
        Merchant merch = new Merchant();
        BeanUtils.copyProperties(merchDTO, merch);
        Merchant merchCreated = merchServices.save(merch);
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/checkUuid")  //name
    public ResponseEntity<String> checkUuid(@RequestBody String uuid) {
        return new ResponseEntity<String>(merchantTokenServices.checkUuid(uuid).get().getMerchantEmail(), HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/generateUuid")  //uuid
    public ResponseEntity<String> generateUuid(@RequestBody String email) {
        MerchantTokenDTO merchTokenDTO = new MerchantTokenDTO();
        MerchantToken merchToken = merchantTokenServices.generateUuid(email);
        merchTokenDTO.setMerchantEmail(email);
        merchTokenDTO.setUuid(merchToken.getUuid());
        BeanUtils.copyProperties(merchToken, merchTokenDTO);
        return new ResponseEntity<String>(merchTokenDTO.getUuid(), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/logout")
    public ResponseEntity<Boolean> logoutButton(@RequestBody String uuid) {
        return new ResponseEntity<Boolean>(merchantTokenServices.deleteUuid(uuid), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<LoginDetailsDTO> loginButton(@RequestBody MerchantLoginDTO merchantLoginDTO) {
        return new ResponseEntity<LoginDetailsDTO>(merchServices.checkLoginDetails(merchantLoginDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/getName/{merchantId}")
    public ResponseEntity<String> getMerchantName(@PathVariable(name = "merchantId") String merchanId) {
        return new ResponseEntity<String>(merchServices.getName(merchanId), HttpStatus.OK);
    }


}

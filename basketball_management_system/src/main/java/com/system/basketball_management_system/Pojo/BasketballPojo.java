package com.system.basketball_management_system.Pojo;

import com.system.basketball_management_system.entity.Basketball;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BasketballPojo {
    private Integer fid;
    private String fname;
    private String fcontact;
    private  String fprice;
    private String flocation;
    private MultipartFile image;
    private MultipartFile image1;
    private MultipartFile image2;
    private String Description;


    public BasketballPojo(Basketball basketball) {
        this.fid = basketball.getBasket_ballId();
        this.fname = basketball.getBasketballname();
        this.fcontact= basketball.getBasketballcontact();
        this.fprice = basketball.getBasketballprice();
        this.flocation = basketball.getBasketballlocation();
        this.Description = basketball.getDescription();

    }
}
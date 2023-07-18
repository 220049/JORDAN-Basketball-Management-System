package com.system.basketball_management_system.Service.Impl;


import com.system.basketball_management_system.Pojo.BasketballPojo;
import com.system.basketball_management_system.Repo.BasketballRepo;
import com.system.basketball_management_system.Service.BasketballService;
import com.system.basketball_management_system.entity.Basketball;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketballServiceImpl implements BasketballService {

    private final BasketballRepo basketballRepo;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/images/";


    @Override
    public BasketballPojo savebasketball(BasketballPojo basketballPojo) throws IOException {
        Basketball basketball = new Basketball();
        if (basketballPojo.getFid()!= null){
            basketball.setBasket_ballId(basketballPojo.getFid());
        }
        basketball.setBasketballname(basketballPojo.getFname());
        basketball.setBasketballprice(basketballPojo.getFprice());
        basketball.setBasketballcontact(basketballPojo.getFcontact());
        basketball.setBasketballlocation(basketballPojo.getFlocation());
        basketball.setDescription(basketballPojo.getDescription());



        if(basketballPojo.getImage1()!=null){
//            System.out.println(UPLOAD_DIRECTORY);
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, basketballPojo.getImage1().getOriginalFilename());
            fileNames.append(basketballPojo.getImage1().getOriginalFilename());
            Files.write(fileNameAndPath, basketballPojo.getImage1().getBytes());

            basketball.setBasketballimage1(basketballPojo.getImage1().getOriginalFilename());
        }
        if(basketballPojo.getImage2()!=null){
//            System.out.println(UPLOAD_DIRECTORY);
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, basketballPojo.getImage2().getOriginalFilename());
            fileNames.append(basketballPojo.getImage2().getOriginalFilename());
            Files.write(fileNameAndPath, basketballPojo.getImage2().getBytes());

            basketball.setBasketballimage2(basketballPojo.getImage2().getOriginalFilename());
        }
        if(basketballPojo.getImage()!=null){
//            System.out.println(UPLOAD_DIRECTORY);
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, basketballPojo.getImage().getOriginalFilename());
            fileNames.append(basketballPojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath, basketballPojo.getImage().getBytes());

            basketball.setBasketballimage(basketballPojo.getImage().getOriginalFilename());
        }
        basketballRepo.save(basketball);
        return new BasketballPojo(basketball);
    }

    @Override
    public Basketball fetchById(Integer id) {
        Basketball basketball = basketballRepo.findById(id).orElseThrow(()-> new RuntimeException("Couldnot find"));
        basketball = Basketball.builder()
                .basket_ballId(basketball.getBasket_ballId())
                .imageBase64(getImageBase64(basketball.getBasketballimage()))
                .image1Base64(getImageBase64(basketball.getBasketballimage1()))
                .image2Base64(getImageBase64(basketball.getBasketballimage2()))
                .basketballname(basketball.getBasketballname())
                .basketballcontact(basketball.getBasketballcontact())
                .basketballprice(basketball.getBasketballprice())
                . basketballlocation(basketball.getBasketballlocation())
                .Description(basketball.getDescription())
                .build();
        return basketball;
    }

    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/images/";
        File file = new File(filePath + fileName);
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return Base64.getEncoder().encodeToString(bytes);
    }

    @Override
    public List<Basketball> fetchAll() {
        return basketballRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        basketballRepo.deleteById(id);
    }

}

package com.system.basketball_management_system;

import com.system.basketball_management_system.Repo.BasketballRepo;
import com.system.basketball_management_system.entity.Basketball;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.annotation.Order;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BasketballRepositoryTest {
    @Autowired
    private BasketballRepo basketballRepo;


    @Test
    @Order(1)
    public void savebasketballTest() {

        Basketball basketball = Basketball.builder()
                .basketballname("rak")
                .basketballcontact("123454")
                .basketballprice("98888888")
                .build();


        basketballRepo.save(basketball);

        Assertions.assertThat(basketball.getBasket_ballId()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void updatebasketballTest(){

        Basketball basketball = Basketball.builder()
                .basketballname("rak")
                .basketballcontact("123454")
                .basketballprice("98888888")
                .build();


        basketballRepo.save(basketball);

        Basketball basketball1 = basketballRepo.findById(basketball.getBasket_ballId()).get();

        basketball1.setBasketballcontact("13265");

        Basketball basketballupdated  = basketballRepo.save(basketball);

        Assertions.assertThat(basketballupdated.getBasketballcontact()).isEqualTo("85207410");

    }
}
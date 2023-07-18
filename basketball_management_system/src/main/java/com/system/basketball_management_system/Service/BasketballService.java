package com.system.basketball_management_system.Service;

import com.system.basketball_management_system.Pojo.BasketballPojo;
import com.system.basketball_management_system.entity.Basketball;

import java.io.IOException;
import java.util.List;

public interface BasketballService {
    BasketballPojo savebasketball(BasketballPojo basketballPojo) throws IOException;

    Basketball fetchById(Integer id);

    List<Basketball> fetchAll();

    void deleteById(Integer id);
}

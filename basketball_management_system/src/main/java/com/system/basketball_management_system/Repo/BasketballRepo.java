package com.system.basketball_management_system.Repo;

import com.system.basketball_management_system.entity.Basketball;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketballRepo extends JpaRepository <Basketball, Integer>{
}

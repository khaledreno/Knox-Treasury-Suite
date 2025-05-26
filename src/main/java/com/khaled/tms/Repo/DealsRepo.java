package com.khaled.tms.Repo;

import com.khaled.tms.DealsComponent.DealsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DealsRepo extends JpaRepository<DealsEntity, Integer> {
Optional<DealsEntity> findDealById(Integer id);

void deleteDealById(Integer id);
boolean existsDealById(Integer id);


}

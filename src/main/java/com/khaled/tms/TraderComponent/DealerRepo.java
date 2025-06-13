package com.khaled.tms.TraderComponent;

import com.khaled.tms.DealsComponent.DealsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DealerRepo extends JpaRepository<DealerEntity,Long> {
    DealerEntity findByName(String name);
    int countDealersByDealerId(Long dealerId);
    //DealerEntity findDealerById(Long id);

}

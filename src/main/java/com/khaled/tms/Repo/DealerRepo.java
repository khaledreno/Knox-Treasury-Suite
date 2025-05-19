package com.khaled.tms.Repo;

import com.khaled.tms.Entity.DealerEntity;
import com.khaled.tms.Entity.DealsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealerRepo extends JpaRepository<DealerEntity,Long> {
    DealerEntity findByName(String name);
}

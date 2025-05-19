package com.khaled.tms.Services;

import com.khaled.tms.Entity.DealerEntity;
import com.khaled.tms.Entity.DealsEntity;
import com.khaled.tms.Repo.DealerRepo;
import com.khaled.tms.Repo.DealsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealerService {

    @Autowired
    private DealerRepo dealerRepo;

    public List<DealerEntity> getDealsRepo() {
        return dealerRepo.findAll();
    }

    public String addDealer(DealerEntity dealerEntity) {
        dealerRepo.save(dealerEntity);
        return "Dealer added with id "+dealerEntity.getDealerId();
    }

}

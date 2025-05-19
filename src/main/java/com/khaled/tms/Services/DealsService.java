package com.khaled.tms.Services;

import com.khaled.tms.Entity.DealsEntity;
import com.khaled.tms.Enums.DealStatus;
import com.khaled.tms.Repo.DealsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DealsService {

@Autowired
private DealsRepo dealsRepo;

public DealsService(DealsRepo dealsRepo) {
    this.dealsRepo = dealsRepo;
}

public DealsRepo getDealById(int id) {
    dealsRepo.findDealById(id);
    return dealsRepo;
}

public List<DealsEntity> fetchAllDeals() {
    return dealsRepo.findAll();
}


public String saveDeal(DealsEntity dealsEntity) {
   dealsEntity.setDealStatus(DealStatus.PENDING);
    dealsRepo.save(dealsEntity);
    return "Deals saved successfully with ID "+dealsEntity.getId();
}

//public boolean IsDealExist(Integer dealId) {
//    return dealsRepo.existsById(dealId);
//}

//public String DeleteDeal(Integer dealId) {
//    if (!IsDealExist(dealId)) {
//        log.info("Deal with id " + dealId + " does not exist");
//    return "Deal with id " + dealId + " does not exist";
//    }
//    dealsRepo.deleteById(dealId);
//    return "Deal with id "+dealId+ " deleted successfully";
//}

}

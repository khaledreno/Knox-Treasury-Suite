package com.khaled.tms.Services;

import com.khaled.tms.Entity.DealsEntity;
import com.khaled.tms.Enums.DealStatus;
import com.khaled.tms.HolidayComponent.HolidaysRepo;
import com.khaled.tms.HolidayComponent.HolidaysService;
import com.khaled.tms.Repo.DealsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DealsService {

@Autowired
private DealsRepo dealsRepo;

@Autowired
private HolidaysService holidaysService;

public DealsService(DealsRepo dealsRepo,HolidaysService holidaysService) {
    this.dealsRepo = dealsRepo;
    this.holidaysService = holidaysService;
}

public DealsRepo getDealById(int id) {
    dealsRepo.findDealById(id);
    return dealsRepo;
}

public List<DealsEntity> fetchAllDeals() {
    return dealsRepo.findAll();
}


public String saveDeal(DealsEntity dealsEntity) {
//    dealsEntity.setValueDate(LocalDateTime.now());
//    log.error("Data isss: "+dealsEntity.getValueDate());
//    LocalDate DealdateOnly = LocalDate.from(dealsEntity.getValueDate().atZone(ZoneId.systemDefault()).toInstant());
//    dealsEntity.setValueDate(LocalDateTime.now());
    log.error("Saving deals entity: {}", dealsEntity);
    log.error("Data isss: " + dealsEntity.getValueDate());

    // Convert LocalDateTime to ZonedDateTime, then get LocalDate
    LocalDate dealDateOnly = dealsEntity.getValueDate()
            .atZone(ZoneId.systemDefault())
            .toLocalDate();

    if (holidaysService.checkHoliday(dealDateOnly)){
        log.info("Holiday found unable to save deal");
        throw new RuntimeException("Holiday found unable to save deal");
    }
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

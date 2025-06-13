package com.khaled.tms.DealsComponent;

import com.khaled.tms.Enums.DealStatus;
import com.khaled.tms.HolidayComponent.HolidaysService;
import com.khaled.tms.Repo.DealsRepo;
import com.khaled.tms.TraderComponent.DealerEntity;
import com.khaled.tms.TraderComponent.DealerRepo;
import com.khaled.tms.TraderComponent.DealerService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Slf4j
@Service
public class DealsService {

@Autowired
private DealsRepo dealsRepo;

@Autowired
private HolidaysService holidaysService;
private DealsMapper dealsMapper;

private DealerEntity dealerEntity;
private DealerRepo dealerRepo;
private DealerService dealerService;

public DealsService(DealsRepo dealsRepo,
                    HolidaysService holidaysService,
                    DealsMapper dealsMapper,
                    DealerRepo dealerRepo,
                    DealerService dealerService) {
    this.dealsRepo = dealsRepo;
    this.holidaysService = holidaysService;
    this.dealsMapper = dealsMapper;
    this.dealerEntity = dealerEntity;
    this.dealerRepo = dealerRepo;
    this.dealerService = dealerService;
}

public DealsRepo getDealById(int id) {
    dealsRepo.findDealById(id);
    return dealsRepo;
}

public List<DealsEntity> fetchAllDeals() {
    return dealsRepo.findAll();
}

@Transactional
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

//    //    int dealsCount= dealsEntity.getDealer().getDealsCount();
//    int dealsCount= dealsEntity.getDealer().getDealsCount();
//    log.info("Deals count: {}", dealsCount);
//    dealsCount++;
//    log.info("Deals count after incr: {}", dealsCount);
//
//    dealsEntity.getDealer().setDealsCount(dealsCount);

//    DealerEntity dealer = dealerRepo.findByName(dealsEntity.getDealer().getName());
//    int dealscount = dealer.getDealsCount();
//    dealer.setDealsCount(dealscount + 1);
//    dealerRepo.save(dealer);
//    log.info("new count "+dealer.getDealsCount());


    //TODO:BROKEN AND LIST OF DEALS IN USER REMOVE IT!
dealerService.incrementDealsforDealer(dealsEntity);
    //connect deals with dea
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

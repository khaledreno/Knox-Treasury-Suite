package com.khaled.tms.TraderComponent;

import com.khaled.tms.DealsComponent.DealsEntity;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DealerService {


    private DealerRepo dealerRepo;
    private DealsEntity dealsEntity;

    public DealerService(DealerRepo dealerRepo) {
        this.dealerRepo = dealerRepo;
    }

    public List<DealerEntity> getDealsRepo() {
        return dealerRepo.findAll();
    }

    public String addDealer(DealerEntity dealerEntity) {

        dealerRepo.save(dealerEntity);
        return "Dealer added with id "+dealerEntity.getDealerId();
    }

    public List<DealerEntity> getAllDealers() {
        return dealerRepo.findAll();
    }

//    public DealerEntity getDealerById(Long dealerId) {
//        DealerEntity dealer = dealerRepo.findDealerById(dealerId);
//    }

    @Transactional
    public void incrementDealsforDealer(DealsEntity dealsEntity) {
        log.error("incrementDealsforDealer called");
       Long dealerID = dealsEntity.getDealer().getDealerId();
       DealerEntity dealer = dealerRepo.findById(dealerID)
               .orElseThrow(() -> new RuntimeException("Dealer not found"));
       // DealerEntity dealer = dealsEntity.getDealer();
        log.info("dealer is "+dealer);
        log.info("dealer id "+dealer.getDealerId());



//        Long dealerID = dealer.getDealerId();
        log.info("incrementDealsforDealer called with id "+dealerID);


    dealer.setDealsCount(dealer.getDealsCount()+1);
        log.error("new dealer "+dealer);
    dealerRepo.save(dealer);
//log.info("dealer "+dealer.getName()+" with id "+dealer.getDealerId()+" deals count was updated and its now "+dealer.getDealsCount());
log.info("dealer "+dealer.getName()+" with id "+dealer.getDealerId()+" deals count was updated and its now "+dealerRepo.countDealersByDealerId(dealerID));
    }

}

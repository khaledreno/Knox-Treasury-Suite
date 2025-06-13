package com.khaled.tms.TraderComponent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DealerController {

    @Autowired
    private DealerService dealerService;

//    public List<DealerService> getDealerService() {
//        return dealerService.get();
//    }

    @PostMapping("/dealer")
    public String AddDealer(@RequestBody DealerEntity dealerEntity) {
        return dealerService.addDealer(dealerEntity);
    }

    @GetMapping("/dealer")
    public List<DealerEntity> getAllDealers() { return dealerService.getAllDealers();
    }
}



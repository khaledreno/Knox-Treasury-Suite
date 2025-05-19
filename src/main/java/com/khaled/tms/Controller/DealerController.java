package com.khaled.tms.Controller;


import com.khaled.tms.Entity.DealerEntity;
import com.khaled.tms.Services.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
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
}

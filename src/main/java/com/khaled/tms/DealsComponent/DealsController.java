package com.khaled.tms.DealsComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DealsController {

    @Autowired
    private DealsService dealsService;


//    @GetMapping("/deals")
//    public List<DealsEntity> getAllDeals() {
//        return dealsService.fetchAllDeals();
//    }

    @GetMapping("/deals")
    public ResponseEntity<List<DealsEntity>> getAllDealsDTO() {
        return ResponseEntity.ok(dealsService.fetchAllDeals());
    }

    @PostMapping("/deals")
    public DealsEntity createDeal(@RequestBody DealsEntity dealsEntity) {
        dealsService.saveDeal(dealsEntity);
        return dealsEntity;
    }



}

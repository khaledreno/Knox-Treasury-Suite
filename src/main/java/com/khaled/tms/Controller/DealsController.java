package com.khaled.tms.Controller;

import com.khaled.tms.Entity.DealsEntity;
import com.khaled.tms.Services.DealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DealsController {

    @Autowired
    private DealsService dealsService;

    @GetMapping("/deals")
    public List<DealsEntity> getAllDeals() {
        return dealsService.fetchAllDeals();
    }

    @PostMapping("/deals")
    public DealsEntity createDeal(@RequestBody DealsEntity dealsEntity) {
        dealsService.saveDeal(dealsEntity);
        return dealsEntity;
    }
}

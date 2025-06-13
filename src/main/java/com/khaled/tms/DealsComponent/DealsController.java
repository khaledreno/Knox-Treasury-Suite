package com.khaled.tms.DealsComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DealsController {

    @Autowired
    private DealsService dealsService;
    private DealsMapper dealsMapper;

    public DealsController(DealsService dealsService, DealsMapper dealsMapper) {
        this.dealsService = dealsService;
        this.dealsMapper = dealsMapper;
    }

    //    @GetMapping("/deals")
//    public List<DealsEntity> getAllDeals() {
//        return dealsService.fetchAllDeals();
//    }
//
//    @GetMapping("/deals")
//    public ResponseEntity<List<DealsEntity>> getAllDealsDTO() {
//        return ResponseEntity.ok(dealsService.fetchAllDeals());
//    }



    @GetMapping("/deals")
    public ResponseEntity<List<DealsDTO>> getAllDeals() {
        List<DealsDTO> DTOdeals = dealsService.fetchAllDeals().stream()
                .map(dealsMapper::dealstoDTO)
                .toList();

        return ResponseEntity.ok(DTOdeals);
    }

    @GetMapping("/dealsDTO")
    public ResponseEntity<List<DealsDTO>> getAllDealsDTO() {

        List<DealsDTO> DTOdeal = dealsMapper.ListDealstoDTO(dealsService.fetchAllDeals());
        return ResponseEntity.ok(DTOdeal);
    }



    @PostMapping("/deals")
    public DealsEntity createDeal(@RequestBody DealsEntity dealsEntity) {
        dealsService.saveDeal(dealsEntity);
        return dealsEntity;
    }



}

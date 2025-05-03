package com.khaled.tms.Controller;

import com.khaled.tms.Entity.ExchangeModel;
import com.khaled.tms.Services.ExchangeRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService ;

    @GetMapping("/convert")
    public ExchangeModel getExchangeRate(
            @RequestParam String symbol,
            @RequestParam double amount) {
//
      log.error(exchangeRateService.getExchangeRateWithAmount(symbol,amount).toString());
    return exchangeRateService.getExchangeRateWithAmount(symbol,amount);
    }


    @GetMapping("/rates")
    public List<ExchangeModel> getExchangeRatePairs(@RequestParam String symbols) {
        return exchangeRateService.getAllExchangeRates(symbols);
    }
}

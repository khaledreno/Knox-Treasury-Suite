//package com.khaled.tms.Services;
//
//import java.math.BigDecimal;
//import jakarta.annotation.PostConstruct;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Service
//public class CachedCurrencyService {
//    //TODO:To make it hidden in
////    private final String API_KEY = "JPcOSDvI4MsJBPR9mMIsodg0WtB0dwz50wmec1dYrjGoyMzumomRdfyqu9hcbx2o";
//    private final String API_KEY = "JPcOSDvI4MsJBPR9mMIsodg0WtB0dwz50wmec1dYrjGoyMzumomRdfyqu9hcbx2o";
////    private final String BASE_URL = "https://api.unirateapi.com/api/convert";    private final String API_KEY = "JPcOSDvI4MsJBPR9mMIsodg0WtB0dwz50wmec1dYrjGoyMzumomRdfyqu9hcbx2o";
//    private final String BASE_URL = "https://api.unirateapi.com/api/convert";
//
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    // Cache structure: "USD_EUR" , latest rate
//    //concurentHashMap is thread safe so multiple thread can read and write
//    private final Map<String, BigDecimal> conversionRates = new ConcurrentHashMap<>();
//
//    @PostConstruct
//    public void init() {
//        updateRates(); // Initial fetch
//    }
//
//    @Scheduled(fixedRate = 10 * 60 * 10) // every 10 minutes
//    public void updateRates() {
//        // You can preload popular currency pairs
//        fetchAndCacheRate("USD", "EUR");
//        fetchAndCacheRate("USD", "GBP");
//        fetchAndCacheRate("EUR", "JPY");
//    }
//
//    private void fetchAndCacheRate(String from, String to) {
//        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
//                .queryParam("api_key", API_KEY)
//                .queryParam("amount", 1)
//                .queryParam("from", from)
//                .queryParam("to", to)
//                .toUriString();
//
//        try {
//            Map<String, Object> response = restTemplate.getForObject(url, Map.class);
//            if (response != null && response.containsKey("result")) {
//                BigDecimal rate = new BigDecimal(response.get("result").toString());
//                conversionRates.put(from + "_" + to, rate);
//            }
//        } catch (Exception e) {
//            System.err.println("Error fetching rate " + from + " to " + to + ": " + e.getMessage());
//        }
//    }
//
//    public BigDecimal convert(BigDecimal amount, String from, String to) {
//        String key = from + "_" + to;
//        BigDecimal rate = conversionRates.get(key);
//        if (rate == null) throw new IllegalArgumentException("Rate not found in cache for " + key);
//        return amount.multiply(rate);
//        }
//    }
//

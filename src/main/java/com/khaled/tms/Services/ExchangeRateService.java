package com.khaled.tms.Services;

import com.khaled.tms.Entity.ExchangeModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ExchangeRateService {
    private final ProjectInfoAutoConfiguration projectInfoAutoConfiguration;
    @Value("${API_KEY}")
    private String apiKey;
    private static final String BASE_URL = "https://api.twelvedata.com/quote";

    private final RestTemplate restTemplate = new RestTemplate();

    public ExchangeRateService(ProjectInfoAutoConfiguration projectInfoAutoConfiguration) {
        this.projectInfoAutoConfiguration = projectInfoAutoConfiguration;
    }


    public ExchangeModel getExchangeRateWithAmount(String symbol, double amount) {
        RestTemplate restTemplate = new RestTemplate();

        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("symbol", symbol)
                .queryParam("apikey", apiKey)
                .toUriString();

        String response = restTemplate.getForObject(url, String.class);
        JSONObject json = new JSONObject(response);

        if (json.has("close")) {
            double price = json.getDouble("close");
            String CurrencyName = json.getString("name");
            double convertedAmount = price * amount;
            log.info("Currency is " + CurrencyName);
            return new ExchangeModel(symbol, amount, price, convertedAmount);
        } else {
            throw new RuntimeException("Error fetching exchange rate: " + json.toString());
        }
    }

    public List<ExchangeModel> getAllExchangeRates(String symbolsRaw) {
// Remove brackets and spaces
        String cleanedSymbols = symbolsRaw
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "");

        String url = BASE_URL + "?symbol=" + cleanedSymbols + "&apikey=" + apiKey;
        log.info("Fetching exchange rates from " + url);

        String apiResponse = restTemplate.getForObject(url, String.class);
        JSONObject response = new JSONObject(apiResponse);
        log.info("response is "+response);

        // Split the symbols into a list
        List<String> symbols = Arrays.asList(cleanedSymbols.split(","));
        log.info("symbols is "+symbols);

        List<ExchangeModel> results = new ArrayList<>();

        for (String symbol : symbols) {
            log.info("Fetching exchange rates from pair " + symbol);
            try {
                if (response !=null) {
                    JSONObject symbolData = response.getJSONObject(symbol);
                    log.info("data is "+symbolData);

                    double price = symbolData.optDouble("close", -1);
                    log.info("close is "+price);

                    if (price != -1) {
                        results.add(new ExchangeModel(symbol, 0.0, price, 0.0));
                    } else {
                        log.error("Price missing for: " + symbol);
                    }
                } else {
                    System.err.println("No data found for: " + symbol);
                }
            } catch (Exception e) {
                log.error("Error for symbol " + symbol + ": " + e.getMessage());
            }
        }

        return results;
    }
}

//    public ExchangeModel getExchangeRateWithAmount(String symbol, double amount) {
//        String formattedSymbol = symbol.replace("/", "");
//        String url = "https://api.twelvedata.com/quote?symbol=" + formattedSymbol + "&apikey=" + apiKey;
//
//        JSONObject response = new JSONObject(restTemplate.getForObject(url, String.class));
//
//        if (response.has("close")) {
//            double price = response.optDouble("close", -1);
//            if (price != -1) {
//                double total = price * amount;
//                return new ExchangeModel(symbol, amount, price, total);
//            }
//        }
//        throw new RuntimeException("Error fetching exchange rate for: " + symbol);
//    }




//
//
//    private static final String BASE_URL = "https://api.twelvedata.com/quote";
//
//@Value("${API_KEY}")
//private  String apiKey;
//    public ExchangeModel getExchangeRate(String symbol, double amount) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
//                .queryParam("symbol", symbol)
//                .queryParam("apikey", apiKey)
//                .toUriString();
//
//        String response = restTemplate.getForObject(url, String.class);
//        JSONObject json = new JSONObject(response);
//
//        if (json.has("close")) {
//            double price = json.getDouble("close");
//            String CurrencyName = json.getString("name");
//            double convertedAmount = price * amount;
//            log.info("Currency is "+CurrencyName);
//            return new ExchangeModel(symbol, price, convertedAmount);
//        } else {
//            throw new RuntimeException("Error fetching exchange rate: " + json.toString());
//        }
//    }

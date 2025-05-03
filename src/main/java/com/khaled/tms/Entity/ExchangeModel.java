package com.khaled.tms.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeModel {
    private String symbol;
    private double price;
    private double amount;
    private double total;
}

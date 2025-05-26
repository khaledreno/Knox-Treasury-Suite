package com.khaled.tms.DealsComponent;

import com.khaled.tms.Entity.DealDirection;
import com.khaled.tms.Enums.DealStatus;
import com.khaled.tms.Enums.DealType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealsDTO {
    private int Id;
    private String dealerName;
    private DealType dealType;
    private String currency1;
    private String currency2;
    private BigDecimal exchangeRate;
    private DealStatus dealStatus;
    private DealDirection direction;
    private LocalDateTime tradeDate;
    private LocalDateTime valueDate;

}





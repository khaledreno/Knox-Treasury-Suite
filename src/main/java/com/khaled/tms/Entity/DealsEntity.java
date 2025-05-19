package com.khaled.tms.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.khaled.tms.Enums.DealStatus;
import com.khaled.tms.Enums.DealType;
import jakarta.jws.soap.SOAPBinding;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "deals")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealsEntity {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int Id;

@ManyToOne
@JoinColumn(name = "trader_id")
private DealerEntity dealer;

@Enumerated(EnumType.STRING)
private DealType dealType;

private String currency1;
private String currency2;

@Column(nullable = false)
private BigDecimal exchangeRate;

@Enumerated(EnumType.STRING)
private DealStatus dealStatus;

@Column(nullable = false)
@Enumerated(EnumType.STRING)
private DealDirection direction;

@CreationTimestamp
@Column(updatable = false)
@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy/MM/dd-HH:mm:ss")
private LocalDateTime tradeDate;

@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy/MM/dd-HH:mm:ss")
private LocalDateTime valueDate;



}

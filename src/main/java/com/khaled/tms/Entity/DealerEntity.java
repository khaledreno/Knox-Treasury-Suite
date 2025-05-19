package com.khaled.tms.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Entity
@Table(name = "dealer_entity")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DealerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer dealerId;
   private String name;
   private int DealsCount;


    @OneToMany(mappedBy = "dealer") // ✅ match the field in DealsEntity
    private List<DealsEntity> listOfDeals;   // ✅ correct collection type

}

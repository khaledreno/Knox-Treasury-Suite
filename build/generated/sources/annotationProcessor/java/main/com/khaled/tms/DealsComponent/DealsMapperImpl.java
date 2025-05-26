package com.khaled.tms.DealsComponent;

import com.khaled.tms.Entity.DealerEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-27T00:46:45+0300",
    comments = "version: 1.6.3, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.13.jar, environment: Java 23 (Oracle Corporation)"
)
@Component
public class DealsMapperImpl implements DealsMapper {

    @Override
    public DealsDTO dealstoDTO(DealsEntity dealsEntity) {
        if ( dealsEntity == null ) {
            return null;
        }

        DealsDTO dealsDTO = new DealsDTO();

        dealsDTO.setDealerName( dealsEntityDealerName( dealsEntity ) );
        dealsDTO.setId( dealsEntity.getId() );
        dealsDTO.setDealType( dealsEntity.getDealType() );
        dealsDTO.setCurrency1( dealsEntity.getCurrency1() );
        dealsDTO.setCurrency2( dealsEntity.getCurrency2() );
        dealsDTO.setExchangeRate( dealsEntity.getExchangeRate() );
        dealsDTO.setDealStatus( dealsEntity.getDealStatus() );
        dealsDTO.setDirection( dealsEntity.getDirection() );
        dealsDTO.setTradeDate( dealsEntity.getTradeDate() );
        dealsDTO.setValueDate( dealsEntity.getValueDate() );

        return dealsDTO;
    }

    @Override
    public DealsEntity DTOtoDealsEntity(DealsDTO dealsDTO) {
        if ( dealsDTO == null ) {
            return null;
        }

        DealsEntity.DealsEntityBuilder dealsEntity = DealsEntity.builder();

        dealsEntity.dealType( dealsDTO.getDealType() );
        dealsEntity.currency1( dealsDTO.getCurrency1() );
        dealsEntity.currency2( dealsDTO.getCurrency2() );
        dealsEntity.exchangeRate( dealsDTO.getExchangeRate() );
        dealsEntity.dealStatus( dealsDTO.getDealStatus() );
        dealsEntity.direction( dealsDTO.getDirection() );
        dealsEntity.tradeDate( dealsDTO.getTradeDate() );
        dealsEntity.valueDate( dealsDTO.getValueDate() );

        return dealsEntity.build();
    }

    private String dealsEntityDealerName(DealsEntity dealsEntity) {
        DealerEntity dealer = dealsEntity.getDealer();
        if ( dealer == null ) {
            return null;
        }
        return dealer.getName();
    }
}

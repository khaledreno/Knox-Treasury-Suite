package com.khaled.tms.DealsComponent;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DealsMapper {

    @Mapping(source = "dealer.name", target = "dealerName")
    DealsDTO dealstoDTO(DealsEntity dealsEntity);

    @Mapping(source = "dealer.name", target = "dealerName")
    List<DealsDTO> ListDealstoDTO(List<DealsEntity> dealsEntityList);

    @InheritInverseConfiguration
    @Mapping(target = "dealer", ignore = true)
    DealsEntity DTOtoDealsEntity(DealsDTO dealsDTO);
}

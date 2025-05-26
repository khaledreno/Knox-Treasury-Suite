package com.khaled.tms.DealsComponent;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DealsMapper {

    @Mapping(source = "dealer.name", target = "dealerName")
    DealsDTO dealstoDTO(DealsEntity dealsEntity);

    @InheritInverseConfiguration
    @Mapping(target = "dealer", ignore = true)
    DealsEntity DTOtoDealsEntity(DealsDTO dealsDTO);
}

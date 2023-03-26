package com.mercadona.mercadona.mapper;

import com.mercadona.mercadona.dto.DestinyDto;
import com.mercadona.mercadona.model.Destiny;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DestinyMapper {

    DestinyMapper INSTANCE = Mappers.getMapper(DestinyMapper.class);

    DestinyDto destinyToDestinyDto(Destiny destiny);

    Destiny destinyDtoToDestiny(DestinyDto destinyDto);
}

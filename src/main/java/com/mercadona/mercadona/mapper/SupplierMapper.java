package com.mercadona.mercadona.mapper;

import com.mercadona.mercadona.dto.SupplierDto;
import com.mercadona.mercadona.model.Supplier;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SupplierMapper {

    SupplierMapper INSTANCE = Mappers.getMapper(SupplierMapper.class);

    SupplierDto supplierToSupplierDto(Supplier supplier);

    Supplier supplierDtoToSupplier(SupplierDto supplierDto);
}

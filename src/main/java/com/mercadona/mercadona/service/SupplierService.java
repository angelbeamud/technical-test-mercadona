package com.mercadona.mercadona.service;

import com.mercadona.mercadona.dto.EANDto;
import com.mercadona.mercadona.dto.SupplierDto;
import com.mercadona.mercadona.mapper.SupplierMapper;
import com.mercadona.mercadona.model.Supplier;
import com.mercadona.mercadona.repository.SupplierRepository;
import com.mercadona.mercadona.validator.EANValidator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * Service that is used to interact with the database supplier table
 */
@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private EANValidator eanValidator;

    /**
     * Gets a supplier
     *
     * @param eanDto EAN
     * @return A supplier
     */
    public SupplierDto getSupplier(EANDto eanDto) {

        EANValidator.validateEAN(eanDto);

        Supplier supplier = this.supplierRepository.findByReferenceCode(eanDto.getSupplierReference()).orElseThrow(()
                -> new NoSuchElementException("Supplier not found " + eanDto.getSupplierReference()));

        return SupplierMapper.INSTANCE.supplierToSupplierDto(supplier);
    }

    /**
     * Creates a supplier
     *
     * @param supplierDto Supplier
     * @return A supplier created
     */
    public SupplierDto createSupplier(SupplierDto supplierDto) {
        return SupplierMapper.INSTANCE.supplierToSupplierDto(this.supplierRepository.save(SupplierMapper.INSTANCE.supplierDtoToSupplier(supplierDto)));
    }

    /**
     * Updates a supplier in database
     *
     * @param eanDto      EAN
     * @param supplierDto Supplier
     * @return A supplier updated
     */
    public SupplierDto updateSupplier(EANDto eanDto, SupplierDto supplierDto) {

        EANValidator.validateEAN(eanDto);

        Supplier supplier = this.supplierRepository.findByReferenceCode(eanDto.getSupplierReference()).orElseThrow(()
                -> new NoSuchElementException("Supplier not found " + eanDto.getSupplierReference()));
        supplier.setReferenceCode(supplierDto.getReferenceCode());
        supplier.setDirection(supplierDto.getDirection());
        supplier.setNameSupplier(supplierDto.getNameSupplier());

        return SupplierMapper.INSTANCE.supplierToSupplierDto(this.supplierRepository.save(supplier));
    }

    /**
     * Deletes a supplier in database
     *
     * @param eanDto EAN
     */
    public void deleteSupplier(EANDto eanDto) {

        EANValidator.validateEAN(eanDto);

        Supplier supplier = this.supplierRepository.findByReferenceCode(eanDto.getSupplierReference()).orElseThrow(()
                -> new NoSuchElementException("Supplier not found " + eanDto.getSupplierReference()));

        try {
            this.supplierRepository.deleteById(supplier.getId());
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Cannot remove the destiny");
        }
    }
}

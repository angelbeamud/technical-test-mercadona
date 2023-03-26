package com.mercadona.mercadona.controller;

import com.mercadona.mercadona.dto.EANDto;
import com.mercadona.mercadona.dto.SupplierDto;
import com.mercadona.mercadona.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Class supplier controller with endpoints CRUD
 */
@RestController
@RequestMapping(value = "/mercadona")
public class SupplierController {


    @Autowired
    private SupplierService supplierService;

    /**
     * Get a supplier
     *
     * @param ean EAN
     * @return A supplier
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/suppliers/{ean}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SupplierDto getSupplier(@PathVariable(value = "ean") Long ean) {
        EANDto eanDto = new EANDto();
        eanDto.setBarCode(ean);
        return this.supplierService.getSupplier(eanDto);
    }

    /**
     * Create a supplier
     *
     * @param supplierDto Supplier
     * @return A supplier
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/suppliers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SupplierDto createSupplier(@RequestBody SupplierDto supplierDto) {
        return this.supplierService.createSupplier(supplierDto);
    }

    /**
     * Update a supplier
     *
     * @param ean         EAN
     * @param supplierDto Supplier
     * @return A supplier
     */
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "/suppliers/{ean}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SupplierDto updateSupplier(@PathVariable(value = "ean") Long ean, @RequestBody SupplierDto supplierDto) {
        EANDto eanDto = new EANDto();
        eanDto.setBarCode(ean);
        return this.supplierService.updateSupplier(eanDto, supplierDto);
    }

    /**
     * Delete a supplier
     *
     * @param ean EAN
     */
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/suppliers/{ean}")
    public void deleteSupplier(@PathVariable(value = "ean") Long ean) {
        EANDto eanDto = new EANDto();
        eanDto.setBarCode(ean);
        this.supplierService.deleteSupplier(eanDto);
    }
}

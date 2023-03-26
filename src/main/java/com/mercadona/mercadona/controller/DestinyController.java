package com.mercadona.mercadona.controller;

import com.mercadona.mercadona.dto.DestinyDto;
import com.mercadona.mercadona.dto.EANDto;
import com.mercadona.mercadona.service.DestinyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Class destiny controller with endpoints CRUD
 */
@RestController
@RequestMapping(value = "/mercadona")
public class DestinyController {

    @Autowired
    private DestinyService destinyService;

    /**
     * Get a destiny
     *
     * @param ean EAN
     * @return A destiny
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/destinies/{ean}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DestinyDto getDestiny(@PathVariable(value = "ean") Long ean) {
        EANDto eanDto = new EANDto();
        eanDto.setBarCode(ean);
        return this.destinyService.getDestiny(eanDto);
    }

    /**
     * Create a destiny
     *
     * @param destinyDto Destiny
     * @return A destiny
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/destinies", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DestinyDto createDestiny(@RequestBody DestinyDto destinyDto) {
        return this.destinyService.createDestiny(destinyDto);
    }

    /**
     * Update a destiny
     *
     * @param ean        EAN
     * @param destinyDto Destiny
     * @return A destiny
     */
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "/destinies/{ean}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DestinyDto updateDestiny(@PathVariable(value = "ean") Long ean, @RequestBody DestinyDto destinyDto) {
        EANDto eanDto = new EANDto();
        eanDto.setBarCode(ean);
        return this.destinyService.updateDestiny(eanDto, destinyDto);
    }

    /**
     * Delete a destiny
     *
     * @param ean EAN
     */
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/destinies/{ean}")
    public void deleteDestiny(@PathVariable(value = "ean") Long ean) {
        EANDto eanDto = new EANDto();
        eanDto.setBarCode(ean);
        this.destinyService.deleteDestiny(eanDto);
    }
}

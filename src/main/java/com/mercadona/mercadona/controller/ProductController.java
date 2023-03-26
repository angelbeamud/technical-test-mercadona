package com.mercadona.mercadona.controller;

import com.mercadona.mercadona.dto.EANDto;
import com.mercadona.mercadona.dto.ProductDto;
import com.mercadona.mercadona.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Class product controller with endpoints CRUD
 */
@RestController
@RequestMapping(value = "/mercadona")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Get a product
     *
     * @param ean EAN
     * @return A product
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/products/{ean}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto getProduct(@PathVariable(value = "ean") Long ean) {
        EANDto eanDto = new EANDto();
        eanDto.setBarCode(ean);
        return this.productService.getProduct(eanDto);
    }

    /**
     * Create a product
     *
     * @param productDto Product
     * @return A product
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/products", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return this.productService.createProduct(productDto);
    }

    /**
     * Update a product
     *
     * @param ean        EAN
     * @param productDto Product
     * @return A product
     */
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping(value = "/products/{ean}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto updateProduct(@PathVariable(value = "ean") Long ean, @RequestBody ProductDto productDto) {
        EANDto eanDto = new EANDto();
        eanDto.setBarCode(ean);
        return this.productService.updateProduct(eanDto, productDto);
    }

    /**
     * Delete a product
     *
     * @param ean EAN
     */
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/products/{ean}")
    public void deleteProduct(@PathVariable(value = "ean") Long ean) {
        EANDto eanDto = new EANDto();
        eanDto.setBarCode(ean);
        this.productService.deleteProduct(eanDto);
    }
}

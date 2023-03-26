package com.mercadona.mercadona.service;

import com.mercadona.mercadona.dto.EANDto;
import com.mercadona.mercadona.dto.ProductDto;
import com.mercadona.mercadona.mapper.DestinyMapper;
import com.mercadona.mercadona.mapper.ProductMapper;
import com.mercadona.mercadona.mapper.SupplierMapper;
import com.mercadona.mercadona.model.Destiny;
import com.mercadona.mercadona.model.Product;
import com.mercadona.mercadona.model.Supplier;
import com.mercadona.mercadona.repository.DestinyRepository;
import com.mercadona.mercadona.repository.ProductRepository;
import com.mercadona.mercadona.repository.SupplierRepository;
import com.mercadona.mercadona.validator.EANValidator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * Service that is used to interact with the database product table
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private DestinyRepository destinyRepository;

    @Autowired
    private EANValidator eanValidator;

    /**
     * Gets a product
     *
     * @param eanDto EAN
     * @return A product
     */
    public ProductDto getProduct(EANDto eanDto) {

        EANValidator.validateEAN(eanDto);

        Long destinyId = eanDto.getDestinyNum() >= 1 || eanDto.getDestinyNum() <= 5 ? 1 : eanDto.getDestinyNum();

        Supplier supplier = this.supplierRepository.findByReferenceCode(eanDto.getSupplierReference()).orElseThrow(()
                -> new NoSuchElementException("Supplier not found " + eanDto.getSupplierReference()));
        Destiny destiny = this.destinyRepository.findById(destinyId).orElseThrow(()
                -> new NoSuchElementException("Destiny not found " + eanDto.getDestinyNum()));
        Product product = this.productRepository.findByReferenceCode(eanDto.getProductReference()).orElseThrow(()
                -> new NoSuchElementException("Product not found " + eanDto.getProductReference()));

        ProductDto productDto = ProductMapper.INSTANCE.productToProductDto(product);
        productDto.setSupplier(SupplierMapper.INSTANCE.supplierToSupplierDto(supplier));
        productDto.setDestiny(DestinyMapper.INSTANCE.destinyToDestinyDto(destiny));

        return productDto;
    }

    /**
     * Creates a product in database
     *
     * @param productDto Product
     * @return Product created
     */
    public ProductDto createProduct(ProductDto productDto) {
        return ProductMapper.INSTANCE.productToProductDto(this.productRepository.save(ProductMapper.INSTANCE.productDtoToProduct(productDto)));
    }

    /**
     * Updates a product in database
     *
     * @param eanDto     EAN
     * @param productDto Product
     * @return A product updated
     */
    public ProductDto updateProduct(EANDto eanDto, ProductDto productDto) {

        EANValidator.validateEAN(eanDto);

        Product product = this.productRepository.findByReferenceCode(eanDto.getProductReference()).orElseThrow(()
                -> new NoSuchElementException("Product not found " + eanDto.getProductReference()));
        product.setNameProduct(productDto.getNameProduct());
        product.setFrozen(productDto.getFrozen());
        product.setReferenceCode(productDto.getReferenceCode());
        product.setPrice(productDto.getPrice());

        return ProductMapper.INSTANCE.productToProductDto(this.productRepository.save(product));
    }

    /**
     * Deletes a product in database
     *
     * @param eanDto EAN
     */
    public void deleteProduct(EANDto eanDto) {

        EANValidator.validateEAN(eanDto);

        Product product = this.productRepository.findByReferenceCode(eanDto.getProductReference()).orElseThrow(()
                -> new NoSuchElementException("Product not found " + eanDto.getProductReference()));

        try {
            this.productRepository.deleteById(product.getId());
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Cannot remove the product");
        }
    }
}

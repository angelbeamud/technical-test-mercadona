package com.mercadona.mercadona.service;

import com.mercadona.mercadona.dto.DestinyDto;
import com.mercadona.mercadona.dto.EANDto;
import com.mercadona.mercadona.mapper.DestinyMapper;
import com.mercadona.mercadona.model.Destiny;
import com.mercadona.mercadona.repository.DestinyRepository;
import com.mercadona.mercadona.validator.EANValidator;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * Service that is used to interact with the database destiny table
 */
@Service
public class DestinyService {

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
    public DestinyDto getDestiny(EANDto eanDto) {

        EANValidator.validateEAN(eanDto);

        Long destinyId = eanDto.getDestinyNum() >= 1 && eanDto.getDestinyNum() <= 5 ? 1 : eanDto.getDestinyNum();

        Destiny destiny = this.destinyRepository.findById(destinyId).orElseThrow(()
                -> new NoSuchElementException("Destiny not found " + eanDto.getDestinyNum()));

        return DestinyMapper.INSTANCE.destinyToDestinyDto(destiny);
    }

    /**
     * Creates a destiny in database
     *
     * @param destinyDto Destiny
     * @return A destiny created
     */
    public DestinyDto createDestiny(DestinyDto destinyDto) {
        return DestinyMapper.INSTANCE.destinyToDestinyDto(this.destinyRepository.save(DestinyMapper.INSTANCE.destinyDtoToDestiny(destinyDto)));
    }

    /**
     * Updates a destiny in database
     *
     * @param eanDto     EAN
     * @param destinyDto Destiny
     * @return A destiny updated
     */
    public DestinyDto updateDestiny(EANDto eanDto, DestinyDto destinyDto) {

        EANValidator.validateEAN(eanDto);

        Long destinyId = eanDto.getDestinyNum() >= 1 && eanDto.getDestinyNum() <= 5 ? 1 : eanDto.getDestinyNum();

        Destiny destiny = this.destinyRepository.findById(destinyId).orElseThrow(()
                -> new NoSuchElementException("Destiny not found " + eanDto.getDestinyNum()));
        destiny.setNameDestiny(destinyDto.getNameDestiny());

        return DestinyMapper.INSTANCE.destinyToDestinyDto(this.destinyRepository.save(destiny));
    }

    /**
     * Deletes a destiny in database
     *
     * @param eanDto EAN
     */
    public void deleteDestiny(EANDto eanDto) {

        EANValidator.validateEAN(eanDto);

        Long destinyId = eanDto.getDestinyNum() >= 1 && eanDto.getDestinyNum() <= 5 ? 1 : eanDto.getDestinyNum();
        Destiny destiny = this.destinyRepository.findById(destinyId).orElseThrow(()
                -> new NoSuchElementException("Destiny not found " + eanDto.getDestinyNum()));

        try {
            this.destinyRepository.deleteById(destiny.getId());
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Cannot remove the destiny");
        }
    }
}

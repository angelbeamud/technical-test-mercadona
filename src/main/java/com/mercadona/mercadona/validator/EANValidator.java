package com.mercadona.mercadona.validator;

import com.mercadona.mercadona.dto.EANDto;
import org.springframework.stereotype.Component;

/**
 * Class to validate EAN
 */
@Component
public class EANValidator {

    /**
     * Validates if the bar code has the correct length
     * @param eanDto EAN
     */
    public static void validateEAN(EANDto eanDto) {

        if (String.valueOf(eanDto.getBarCode()).length() != 13){
            throw new IllegalArgumentException("Bad EAN code " + eanDto.getBarCode());
        }
    }
}

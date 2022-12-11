package com.ladywears.emtproekt.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MarkaNotFoundException extends RuntimeException {
    public MarkaNotFoundException(Long id) {
        super(String.format("Proizvoditel so brendot %d ne e pronajden vo magacinot!", id));
    }
}

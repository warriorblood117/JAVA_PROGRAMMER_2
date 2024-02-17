package com.aulamatriz.product.product.services;

import com.aulamatriz.product.product.dto.ProductDTO;
import org.springframework.http.ResponseEntity;

public interface IProductService {

    ResponseEntity save(ProductDTO productDTO);

    ResponseEntity getAll();

    ResponseEntity update(ProductDTO productDTO, long id);
    ResponseEntity deleteById(long id);


}

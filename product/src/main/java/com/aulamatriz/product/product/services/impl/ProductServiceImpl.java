package com.aulamatriz.product.product.services.impl;

import com.aulamatriz.product.product.dto.ProductDTO;
import com.aulamatriz.product.product.entity.ProductEntity;
import com.aulamatriz.product.product.repository.ProductRepository;
import com.aulamatriz.product.product.services.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public ResponseEntity<?> save(ProductDTO productDTO) {
        ProductEntity productEntity =  new ProductEntity();
        productEntity.setName(productDTO.getName());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setStock(productDTO.getStock());
        return  ResponseEntity.ok(productRepository.save(productEntity));
    }

    @Override
    public ResponseEntity getAll() {
        var listUser = productRepository.findAll();
        return ResponseEntity.ok(listUser);
    }

    @Override
    public ResponseEntity update(ProductDTO productDTO, long id) {
        Optional<ProductEntity> optionalProductEntity =  productRepository.findById(id);
        if(optionalProductEntity.isPresent()){
            ProductEntity productEntity =  optionalProductEntity.get();
            productEntity.setName(productDTO.getName());
            productEntity.setDescription(productDTO.getDescription());
            productEntity.setPrice(productDTO.getPrice());
            productEntity.setStock(productDTO.getStock());
            var updateProductEntity = productRepository.save(productEntity);
            return  ResponseEntity.status(HttpStatus.OK).body(updateProductEntity);

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    public ResponseEntity deleteById(long id) {
        productRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

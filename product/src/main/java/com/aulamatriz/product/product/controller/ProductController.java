package com.aulamatriz.product.product.controller;

import com.aulamatriz.product.product.controller.doc.ProductDoc;
import com.aulamatriz.product.product.dto.ProductDTO;
import com.aulamatriz.product.product.services.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductController implements ProductDoc {

    private  final IProductService iProductService;

    @Override
    public ResponseEntity createProduct(ProductDTO productDTO) {
        return  iProductService.save(productDTO);
    }

    @Override
    public ResponseEntity getAll() {
        return iProductService.getAll();
    }

    @Override
    public ResponseEntity update(ProductDTO productDTO, long id) {
        return iProductService.update(productDTO,id);
    }

    @Override
    public ResponseEntity delete(long id) {
        return iProductService.deleteById(id);
    }

}

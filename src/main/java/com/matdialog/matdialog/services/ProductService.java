package com.matdialog.matdialog.services;

import com.matdialog.matdialog.dto.ProductRepository;
import com.matdialog.matdialog.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    public Product addNewProduct(Product product) {
       return repository.save(product);
    }
}

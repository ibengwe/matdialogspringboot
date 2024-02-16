package com.matdialog.matdialog.controller;

import com.matdialog.matdialog.entity.ImageModal;
import com.matdialog.matdialog.entity.Product;
import com.matdialog.matdialog.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController {

    private  final ProductService service;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Product addNewProduct(@RequestPart(value = "product",required = false) Product product ,
                                 @RequestPart("imageFile") MultipartFile[] file)
                                 {
                                     try {
                                         Set<ImageModal> images=uploadImage(file);
                                         product.setProductImages(images);
                                         return service.addNewProduct(product);
                                     }catch (Exception e){
                                         System.out.println(e.getMessage());
                                     }
                                     return null;
    }
    public Set<ImageModal> uploadImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModal> imageModals=new HashSet<>();
        for(MultipartFile file:multipartFiles){
            ImageModal imageModal=new ImageModal(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            imageModals.add(imageModal);
        }
        return imageModals;
    }
}

package com.application.rest.controllers;

import com.application.rest.controllers.dto.ProductDTO;
import com.application.rest.entities.Product;
import com.application.rest.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    // 🔹 FIND BY ID
    @GetMapping("/find/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {

        return productService.findById(id)
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .maker(product.getMaker()) // ⚠️ ver nota abajo
                        .build())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 FIND ALL
    @GetMapping("/findAll")
    public ResponseEntity<List<ProductDTO>> findAll() {

        List<ProductDTO> productList = productService.findAll()
                .stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .maker(product.getMaker()) // ⚠️ ver nota abajo
                        .build())
                .toList();

        return ResponseEntity.ok(productList);
    }

    // 🔹 SAVE
    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody ProductDTO productDTO) throws Exception {

        if (productDTO.getName() == null || productDTO.getName().isBlank()
                || productDTO.getPrice() == null
                || productDTO.getMaker() == null) {

            return ResponseEntity.badRequest().build();
        }

        Product product = Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .maker(productDTO.getMaker())
                .build();

        productService.save(product);

        return ResponseEntity
                .created(new URI("/api/products/save"))
                .build();
    }

    // 🔹 UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity<Void> update(
            @PathVariable Long id,
            @RequestBody ProductDTO productDTO) {

        Optional<Product> productOptional = productService.findById(id);

        if (productOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Product product = productOptional.get();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setMaker(productDTO.getMaker());

        productService.save(product);

        return ResponseEntity.ok().build();
    }

    // 🔹 DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {

        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

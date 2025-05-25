package com.spring.SpringSecurity_03.SpringSecurity_03.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public ResponseEntity<String> createProduct() {
        return ResponseEntity.ok("Product created successfully.");
    }

    @GetMapping("/read")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'CASHIER', 'USER')")
    public ResponseEntity<String> readProduct() {
        return ResponseEntity.ok("Product read successfully.");
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER', 'CASHIER')")
    public ResponseEntity<String> updateProduct() {
        return ResponseEntity.ok("Product updated successfully.");
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteProduct() {
        return ResponseEntity.ok("Product deleted successfully.");
    }
}

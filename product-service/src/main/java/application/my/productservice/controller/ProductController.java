package application.my.productservice.controller;

import application.my.productservice.model.Product;
import application.my.productservice.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public boolean isInStock(@PathVariable String id) {
        return productService.isInStock(id);
    }

    @GetMapping
    public List<Product> getProductCatalog() {
        return productService.getAllProducts();
    }

}

package application.my.productservice.service;

import application.my.productservice.model.Product;
import application.my.productservice.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String id) {
        log.info("Product {} was requested", id);
        return productRepository.findById(id).orElseThrow(()->
                new RuntimeException(String.format("There is no product with id %s", id)));
    }
    public boolean isInStock(String id) {
        return getProductById(id).getAmount()>0;
    }

    @PostConstruct
    public void fillDB() {
        Product p1 = new Product();
        p1.setName("IPhone 11");
        p1.setPrice(BigDecimal.valueOf(1000));
        p1.setAmount(10);

        Product p2 = new Product();
        p2.setName("MacBook");
        p2.setPrice(BigDecimal.valueOf(2000));
        p2.setAmount(0);

        String p1ID = productRepository.save(p1).getId();
        String p2ID = productRepository.save(p2).getId();

        log.info("{} id is {}", p1.getName(), p1.getId());
        log.info("{} id is {}", p2.getName(), p2.getId());
    }
}

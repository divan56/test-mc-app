package application.my.productservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
@Data
public class Product {
    private String id;

    private String name;

    private BigDecimal price;

    private int amount;

}

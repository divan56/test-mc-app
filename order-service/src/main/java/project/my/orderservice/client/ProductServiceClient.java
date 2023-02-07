package project.my.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("product-service")
public interface ProductServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "product/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean isInStock(@PathVariable String id);
}

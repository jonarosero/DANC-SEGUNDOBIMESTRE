package tec.utpl.store.serviceshopping.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tec.utpl.store.serviceshopping.model.Product;

import java.util.Map;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id);

    @PutMapping(value = "/products/stock/{id}")
    public ResponseEntity<Product> updateStockProduct(@PathVariable("id") Long id,@RequestBody Map<String, Double> requestBody);
}

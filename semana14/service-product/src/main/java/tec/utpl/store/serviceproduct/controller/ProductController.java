package tec.utpl.store.serviceproduct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tec.utpl.store.serviceproduct.entity.Category;
import tec.utpl.store.serviceproduct.entity.Product;
import tec.utpl.store.serviceproduct.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listProducts(@RequestParam(name="categoryId", required = false) Long categoryId){
        List<Product> products = new ArrayList<>();
        if (null  == categoryId){
            products = productService.listAllProducts();
        }else {
            products = productService.findByCategory(Category.builder().id(categoryId).build());
        }



        if(products.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        Product product = productService.getProduct(id);
        if (null == product){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product productCreate = productService.createProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(productCreate);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id,  @RequestBody Product product){
        product.setId(id);

        Product productDB = productService.updateProduct(product);

        if (productDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id){
        Product productDelete = productService.deleteProduct(id);

        if(productDelete!=null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Producto eliminado");
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Product> updateStockProduct(@PathVariable("id") Long id,@RequestBody Map<String, Double> requestBody){
        if (!requestBody.containsKey("quantity")) {
            return ResponseEntity.badRequest().build();
        }

        Double quantity = requestBody.get("quantity");

        Product product = productService.updateStock(id, quantity);

        if (product==null){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }
}

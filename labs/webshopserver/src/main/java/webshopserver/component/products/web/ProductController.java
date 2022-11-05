package webshopserver.component.products.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webshopserver.component.products.domain.Product;
import webshopserver.component.products.repository.ProductRepository;
import webshopserver.component.products.service.ProductDTO;
import webshopserver.component.products.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping()
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDto) {
        productService.addProduct(productDto);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }
    @GetMapping("/{productnumber}")
    public ResponseEntity<?> getProduct(@PathVariable String productnumber) {
        ProductDTO productDTO = productService.getProduct(productnumber);
        return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }


}

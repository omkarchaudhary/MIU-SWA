package productservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import productservice.domain.Product;
import productservice.rest.ProductFeignClient;

@RestController
public class ProductController {

    @Autowired
    ProductFeignClient productFeignClient;

    @RequestMapping("/product/{productNbr}")
    public ResponseEntity<?> numberOfProductsInStock(@PathVariable String productNbr) {
        int numberOfProduct = productFeignClient.numberOfProductsInStock(productNbr);
        return new ResponseEntity<>(numberOfProduct, HttpStatus.OK);
    }
}

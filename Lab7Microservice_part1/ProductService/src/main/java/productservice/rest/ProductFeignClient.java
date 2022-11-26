package productservice.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(name = "product-service", url = "http://localhost:8900")
//This is not required as ProductService is register in Eureka
@FeignClient(name = "StockService")
public interface ProductFeignClient {
    @RequestMapping("/stock/{productNbr}")
    public int numberOfProductsInStock(@PathVariable String productNbr);
}

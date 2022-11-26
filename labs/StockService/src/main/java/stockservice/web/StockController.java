package stockservice.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import stockservice.domain.Stock;

@RestController
public class StockController {
    @GetMapping(path = "/stock/{productNbr}")
    public ResponseEntity<?> numberOfProductsInStock(@PathVariable String productNbr){
        Stock stock = new Stock();
        int numberOfProduct = productNbr.equals(stock.getProductNumber()) ? stock.getAvailableQuantity() : 0;
        return new ResponseEntity<>(numberOfProduct,HttpStatus.OK);
    }
}

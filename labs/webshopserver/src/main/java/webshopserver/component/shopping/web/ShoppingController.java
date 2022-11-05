package webshopserver.component.shopping.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webshopserver.component.shopping.service.ProductDTO;
import webshopserver.component.shopping.service.ShoppingCartDTO;
import webshopserver.component.shopping.service.ShoppingCartService;

@RestController
@RequestMapping("/cart")
public class ShoppingController {
    @Autowired
    private ShoppingCartService shoppingService;

    @PostMapping(value = "/{cartId}/{quantity}")
    public ResponseEntity<?> addToCart(@PathVariable String cartId, @PathVariable int quantity, @RequestBody ProductDTO productDto) {
        shoppingService.addToCart(cartId, productDto, quantity);
        return new ResponseEntity<ShoppingCartDTO>(HttpStatus.OK);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<?> getCart(@PathVariable String cartId) {
        ShoppingCartDTO cart = shoppingService.getCart(cartId);
        return new ResponseEntity<ShoppingCartDTO>(cart, HttpStatus.OK);
    }
}

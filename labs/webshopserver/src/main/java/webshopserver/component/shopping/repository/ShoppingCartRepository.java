package webshopserver.component.shopping.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import webshopserver.component.shopping.domain.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart,String> {
}

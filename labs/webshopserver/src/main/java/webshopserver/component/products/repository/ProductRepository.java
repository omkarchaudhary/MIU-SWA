package webshopserver.component.products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import webshopserver.component.products.domain.Product;

public interface ProductRepository extends MongoRepository<Product,String> {
}

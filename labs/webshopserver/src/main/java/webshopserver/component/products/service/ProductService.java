package webshopserver.component.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webshopserver.component.products.domain.Product;
import webshopserver.component.products.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public void addProduct(ProductDTO productDto) {
        Product product = ProductAdapter.getProduct(productDto);
        productRepository.save(product);
    }
    public ProductDTO getProduct(String productNumber){
        Optional<Product> product = productRepository.findById(productNumber);
        if(product.isPresent()){
            return ProductAdapter.getProductDTO(product.get());
        }
        return null;
    }
}

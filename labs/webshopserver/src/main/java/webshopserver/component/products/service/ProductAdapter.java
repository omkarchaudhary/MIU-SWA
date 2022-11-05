package webshopserver.component.products.service;

import webshopserver.component.products.domain.Product;

public class ProductAdapter {
    public static Product getProduct(ProductDTO productDTO) {
        Product product = new Product(
                productDTO.getProductNumber(),
                productDTO.getPrice(),
                productDTO.getDescription()
        );
        return product;
    }

    public static ProductDTO getProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO(
                product.getProductNumber(),
                product.getPrice(),
                product.getDescription()
        );
        return productDTO;
    }
}

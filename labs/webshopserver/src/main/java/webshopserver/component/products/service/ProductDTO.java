package webshopserver.component.products.service;

public class ProductDTO {
    private String productNumber;
    private double price;
    private String description;

    public ProductDTO() {
    }

    public ProductDTO(String productNumber, double price, String description) {
        this.productNumber = productNumber;
        this.price = price;
        this.description = description;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}

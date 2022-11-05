package webshopclient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProductDTO {
    @Id
    String productNumber;
    double price;
    String description;

    public ProductDTO(String productnumber, String description, double price) {
        super();
        this.productNumber = productnumber;
        this.price = price;
        this.description = description;
    }

    public ProductDTO() {

    }

    public String getProductnumber() {
        return productNumber;
    }

    public void setProductnumber(String productnumber) {
        this.productNumber = productnumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productnumber='" + productNumber + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}

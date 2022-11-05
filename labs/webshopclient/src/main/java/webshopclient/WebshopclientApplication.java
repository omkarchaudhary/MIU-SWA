package webshopclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WebshopclientApplication implements CommandLineRunner {

	@Autowired
	private RestOperations restTemplate;
	public static void main(String[] args) {
		SpringApplication.run(WebshopclientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//----------------------- Create Products
		restTemplate.postForLocation("http://localhost:8080/products", new ProductDTO("CS33","PC",1050.0));
		restTemplate.postForLocation("http://localhost:8080/products", new ProductDTO("CS44","IPad",475.0));

		//------------------Add product to shoppingcart
		ProductDTO product = restTemplate.getForObject("http://localhost:8080/products/CS33", ProductDTO.class);
		restTemplate.postForLocation("http://localhost:8080/cart/1/3", product);
		//------------------Get product from shoppingcart
		product = restTemplate.getForObject("http://localhost:8080/products/CS44", ProductDTO.class);
		restTemplate.postForLocation("http://localhost:8080/cart/1/2", product);

		//--------------------------Get the shopping cart
		ShoppingCartDTO cart = restTemplate.getForObject("http://localhost:8080/cart/1", ShoppingCartDTO.class);
		System.out.println("\n-----Shoppingcart-------");
		if (cart != null) cart.print();
	}

	@Bean
	RestOperations restOperations(){
		return new RestTemplate();
	}
}

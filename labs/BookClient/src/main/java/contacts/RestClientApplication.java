package contacts;

import books.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {
	@Autowired
	private RestOperations restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String serverUrl = "http://localhost:8080/book";
		// add java
		restTemplate.postForLocation(serverUrl, new Book("isbn1","John","Java",120.0));
		// add Microservice
		restTemplate.postForLocation(serverUrl, new Book("isbn2","Peter","Microservice",220.0));
		// get frank
		Book book= restTemplate.getForObject(serverUrl+"/{isbn}", Book.class, "isbn1");
		System.out.println("----------- get Java-----------------------");
		System.out.println(book.getAuthor()+" "+book.getTitle());
        // get all
		Book[] books= restTemplate.getForObject(serverUrl, Book[].class);
		System.out.println("----------- get all books-----------------------");
		System.out.println(books);
		// update frank
		book.setTitle("Java updated");
		restTemplate.put(serverUrl+"/{isbn}", book, book.getIsbn());

		// get all
		books= restTemplate.getForObject(serverUrl, Book[].class);
		System.out.println("----------- get all book-----------------------");
		System.out.println(books);
		// delete John
		restTemplate.delete(serverUrl+"/{isbn}", "isbn1");

	}

	@Bean
	RestOperations restTemplate() {
		return new RestTemplate();
	}
}

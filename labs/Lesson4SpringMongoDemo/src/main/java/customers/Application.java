package customers;

import customers.domain.Address;
import customers.domain.CreditCard;
import customers.domain.Customer;
import customers.domain.Student;
import customers.repository.CustomerRepository;
import customers.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        // create customer
		Customer customer = new Customer(101,"John doe", "johnd@acme.com", "0622341678");
		CreditCard creditCard = new CreditCard("12324564321", "Visa", "11/23");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		customer = new Customer(109,"John Jones", "jones@acme.com", "0624321234");
		creditCard = new CreditCard("657483342", "Visa", "09/23");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		customer = new Customer(66,"James Johnson", "jj123@acme.com", "068633452");
		creditCard = new CreditCard("99876549876", "MasterCard", "01/24");
		customer.setCreditCard(creditCard);
		customerRepository.save(customer);
		//get customers
		System.out.println(customerRepository.findById(66).get());
		System.out.println(customerRepository.findById(101).get());
		System.out.println("-----------All customers ----------------");
		System.out.println(customerRepository.findAll());
		//update customer
		customer = customerRepository.findById(101).get();
		customer.setEmail("jd@gmail.com");
		customerRepository.save(customer);
		System.out.println("-----------find by phone ----------------");
		System.out.println(customerRepository.findByPhone("0622341678"));
		System.out.println("-----------find by email ----------------");
		System.out.println(customerRepository.findCustomerWithEmail("jj123@acme.com"));
		System.out.println("-----------find customers with a certain type of creditcard ----------------");
		List<Customer> customers = customerRepository.findCustomerWithCreditCardType("Visa");
		for (Customer cust : customers){
			System.out.println(cust);
		}

		System.out.println("-----------find by name ----------------");
		System.out.println(customerRepository.findByName("John doe"));

		// Create Address
		Address address1 = new Address(1l,"4th Street","Fairfield","52257");
		Student john = new Student(1l,"John","9876554321","john@gmail.com",address1);
		studentRepository.save(john);
		Address address2 = new Address(2l,"5th Street","Washington","52257");
		Student jasmine = new Student(2l,"Jasmine","9876554322","jasmine@gmail.com",address2);
		studentRepository.save(jasmine);
		Address address3 = new Address(3l,"6th Street","Ottuma","52257");
		Student peter = new Student(3l,"Peter","9876554323","peter@gmail.com",address3);
		studentRepository.save(peter);
		Address address4 = new Address(4l,"7th Street","Burlington","52257");
		Student erica = new Student(4l,"Erica","9876554324","erica@gmail.com",address4);
		studentRepository.save(erica);
		Address address5 = new Address(5l,"8th Street","Iowa","52257");
		Student prem = new Student(5l,"Prem","9876554325","prem@gmail.com",address5);
		studentRepository.save(prem);

		// Get all Student
		System.out.println("------------- Get All Student-------------------");
		List<Student> students = studentRepository.findAll();
		for(Student student : students){
			System.out.println(student);
		}
		System.out.println("-----------Get Student by Name-------------");
		List<Student> studentByNameList = studentRepository.findByName("Erica");
		for(Student student : studentByNameList){
			System.out.println(student);
		}

		System.out.println("-----------Get Student by PhoneNumber-------------");
		Student studentByPhone = studentRepository.findByPhoneNumber("9876554325");
		System.out.println(studentByPhone);

		System.out.println("-----------Get Student by City-------------");
		List<Student> studentByCity = studentRepository.findByCity("Fairfield");
		for(Student student : studentByCity){
			System.out.println(student);
		}

	}

}

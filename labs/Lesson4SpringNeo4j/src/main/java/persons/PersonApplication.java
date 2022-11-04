package persons;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import persons.student.Course;
import persons.student.Student;
import persons.student.StudentRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableNeo4jRepositories
@ComponentScan
public class PersonApplication implements CommandLineRunner{
	
	@Autowired
	PersonRepository personRepository;
	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		personRepository.deleteAll();
		studentRepository.deleteAll();

		Person greg = new Person("Greg");
		Person roy = new Person("Roy");
		Person bob = new Person("Bob");
		greg.worksWith(roy);
		greg.worksWith(bob);
		roy.worksWith(bob);

		List<Person> team = Arrays.asList(greg, roy, bob);


		personRepository.save(greg);
		personRepository.save(roy);
		personRepository.save(bob);


		System.out.println("Lookup each person by name...");
		team.stream().forEach(person -> System.out.println( personRepository.findByName(person.getName())));

		List<Person> teammates = personRepository.findByTeammatesName(bob.getName());
		System.out.println("The following have Bob as a teammate...");
		teammates.stream().forEach(person -> System.out.println( person.getName()));

		//------- Student----------------
		Student gregS = new Student("Greg");
		Student royS = new Student("Roy");
		Student bobS = new Student("Bob");
		Course sa = new Course("CS530","Software Architecture");
		Course asd = new Course("CS544","Advance Software development");
		Course se = new Course("CS453","Software Engineering");
		gregS.hasCourse(sa);
		royS.hasCourse(asd);
		bobS.hasCourse(se);

		studentRepository.save(gregS);
		studentRepository.save(royS);
		studentRepository.save(bobS);


		System.out.println("....Student with the course...");
		List<Student> students = studentRepository.findByCourseNumber(sa.getCourseNumber());
		System.out.println("------ Student with SA-----");
		students.stream().forEach(student -> System.out.println( student.getName()));
	}
}

package customers.repository;

import customers.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student,Long> {
    List<Student> findByName(String name);
    Student findByPhoneNumber(String phoneNumber);

    @Query(" {'address.city' : ?0}")
    List<Student> findByCity(String city);
}

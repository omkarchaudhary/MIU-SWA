package repositories;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByName(String name);
    Student findByPhoneNumber(String phoneNumber);

    @Query("select s from Student s where s.address.city= :city")
    List<Student> findByCity(String city);
}

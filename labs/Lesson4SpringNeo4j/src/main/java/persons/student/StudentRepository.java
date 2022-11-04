package persons.student;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface StudentRepository extends Neo4jRepository<Student,Long> {
    @Query("MATCH (s:Student) -[rel:TAKES] -> (c:Course {courseNumber: $coursenumber}) RETURN s")
    List<Student> findByCourseNumber(String coursenumber);
}

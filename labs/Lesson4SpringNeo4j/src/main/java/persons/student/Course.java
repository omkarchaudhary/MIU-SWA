package persons.student;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String courseNumber;
    private String Name;

    public Course() {
    }

    public Course(String courseNumber, String name) {
        this.courseNumber = courseNumber;
        Name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getName() {
        return Name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseNumber='" + courseNumber + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }

    public void setName(String name) {
        Name = name;
    }
}

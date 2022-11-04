package customers.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;

@Document
public class Student {
    @Id
    private Long studentId;
    private String name;
    private String phoneNumber;
    private String email;

    private Address address;

    public Student() {
    }

    public Student(Long studentId, String name, String phoneNumber, String email, Address address) {
        this.studentId = studentId;
        this.name = name;
        phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public Long getstudentId() {
        return studentId;
    }

    public void setstudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", PhoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}

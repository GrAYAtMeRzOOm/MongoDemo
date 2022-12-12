package com.gray.mongodemo;

import com.gray.mongodemo.model.Address;
import com.gray.mongodemo.model.Gender;
import com.gray.mongodemo.model.Student;
import com.gray.mongodemo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MongoDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(StudentRepository repository) {
        return args -> {
            Address address = new Address();
            address.setAddress("eden park");
            address.setCity("london");
            address.setCountry("England");
            address.setPostalCode("45");

            String email = "john@mail.com";
            Student student = new Student();
            student.setFirstName("John");
            student.setLastName("Doe");
            student.setGender(Gender.MALE);
            student.setEmail(email);
            student.setAddress(address);
            student.setFavSubjects(Arrays.asList("Maths", "Science", "English"));
            student.setCreated(LocalDateTime.now());
            student.setTotalSpentInBooks(BigDecimal.valueOf(500.00));

            if(repository.findStudentByEmail(email).isPresent()){
                System.out.println(student +" Already Exits");
            }else {
                System.out.println("Inserting Students "+ student);
                repository.insert(student);
            }
//            insertStudentByCriteriaQuery(repository, mongoTemplate, email, student);

        };
    }

    private static void insertStudentByCriteriaQuery(StudentRepository repository, MongoTemplate mongoTemplate, String email, Student student) {
        Query query = new Query();
        query.addCriteria(Criteria.where("email").is(email));

        List<Student> students = mongoTemplate.find(query, Student.class);
        if (students.size() > 1) {
            throw new IllegalStateException("Found students more than one for the Email " + email);
        }
        if (students.isEmpty()) {
            System.out.println("Inserting Students "+ student);
            repository.insert(student);
        }else {
            System.out.println(student +" Already Exits");
        }
    }
}

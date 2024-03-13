package org.example.dbhw;

import lombok.RequiredArgsConstructor;
import org.example.dbhw.entity.Student;
import org.example.dbhw.repository.SchoolRepository;
import org.example.dbhw.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.example.dbhw.entity.School;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class DbhwApplication implements CommandLineRunner {
	private final SchoolRepository schoolRepository;
	private final StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(DbhwApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		School school = new School(1L, "RPHMS",900);
		School school1 = new School(2L, "NIS",500);
		School school2 = new School(3L, "KTL",200);

		List<School> schoolList= new ArrayList<>();
		schoolList.add(school);
		schoolList.add(school1);
		schoolList.add(school2);
		schoolRepository.saveAll(schoolList);
		Student student = new Student(1L, "Ramazan", "Roma", "rama@gmail.com", 23,99);
		Student student1 = new Student(2L, "Beibarys", "Bob", "biba@gmail.com", 28,97);
		Student student2 = new Student(3L, "Adi", "Kek", "adi@gmail.com", 20,100);
		studentRepository.save(student);
		studentRepository.save(student1);
		studentRepository.save(student2);
		List <Student> studentList = studentRepository.findStudentByFirstName("Ramazan");
		System.out.println("First method findStudentsByName result " + studentList);
		List<Student> studentList1 = studentRepository.findStudentByAge(20);
		System.out.println("Second method findStudentByAge result " + studentList1);
		School school3 = schoolRepository.findSchoolByName("KTL");
		System.out.println("Third method findSchoolByName result " + school3);
		int numberOfStudents = schoolRepository.getNumberOfStudentsById(3L);
		System.out.println("Fourth method getNumberOfStudentsById " + numberOfStudents);

	}
}

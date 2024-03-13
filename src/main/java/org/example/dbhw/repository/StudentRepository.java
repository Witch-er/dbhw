package org.example.dbhw.repository;

import org.example.dbhw.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findStudentByFirstName(String firstName);
    List<Student> findStudentByAge(int age);

}

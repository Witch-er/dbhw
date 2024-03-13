package org.example.dbhw.repository;

import org.example.dbhw.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SchoolRepository extends JpaRepository<School, Long> {
    School findSchoolByName(String name);
    @Query("select s.sumOfStudents from School s where s.id = :id")
    int getNumberOfStudentsById(Long id);

}

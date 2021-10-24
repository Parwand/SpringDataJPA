package net.parwand.springdatajpa.repository;

import net.parwand.springdatajpa.entity.Guardian;
import net.parwand.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentByEmail(String email);

    // JPQL
    @Query("select s from Student s WHERE s.guardian= ?1")
    Student findStudentByGuardianName(Guardian guardian);

    // Native SQL
    @Query(
            value = "SELECT * FROM student AS s WHERE s.email = ?1",
            nativeQuery = true)
    Student findStudentByEmailsWithNative(String email);

    @Query(
            value = "SELECT * FROM student AS s WHERE s.firstname  = :firstname AND s.lastname = :lastname",
            nativeQuery = true)
    Student findStudentByFirstnameAndLastName(@Param("firstname") String firstname, @Param("lastname") String lastName);
}

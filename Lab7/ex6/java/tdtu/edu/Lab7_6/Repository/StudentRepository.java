package tdtu.edu.Lab7_6.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tdtu.edu.Lab7_6.model.Student;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.age >= :age")
    public List<Student> findStudentsByAge(@Param("age") int age);

    @Query("SELECT COUNT(s) FROM Student s WHERE s.ielts = :ielts")
    public long countByIelts(@Param("ielts") double ielts);

    @Query("SELECT s FROM Student s WHERE lower(s.name) LIKE %:name%")
    public List<Student> findByName(@Param("name") String name);
}

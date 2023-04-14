package tdtu.edu.Lab7_4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.Lab7_4.model.Student;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByAgeGreaterThanEqual(int age);

    public long countByIelts(double ieltsScore);

    public List<Student> findByNameContainingIgnoreCase(String name);
}

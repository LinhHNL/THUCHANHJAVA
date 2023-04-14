package tdtu.edu.Lab7_3.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.Lab7_3.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}

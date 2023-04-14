package tdtu.edu.Lab7_6.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import tdtu.edu.Lab7_6.model.Student;

public interface CloneStudentRepository extends PagingAndSortingRepository<Student, Integer> {
    public Page<Student> findAllByOrderByAgeDescIeltsAsc(Pageable pageable);

}

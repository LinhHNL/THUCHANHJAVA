package tdtu.edu.Lab7_4.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.Lab7_4.Repository.StudentRepository;
import tdtu.edu.Lab7_4.model.Student;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServices {
    @Autowired
    private StudentRepository studentRepo;
    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepo.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepo.findById(id);
    }

    public Student updateStudent(Student updatedStudent) {
        return studentRepo.save(updatedStudent);
    }

    public void deleteStudentById(Long id) {
        studentRepo.deleteById(id);
    }

    public List<Student> findStudentsByAgeGreaterThanEqual(int age) {
        return studentRepo.findByAgeGreaterThanEqual(age);
    }

    public long countStudentsByIeltsScore(double ieltsScore) {
        return studentRepo.countByIelts(ieltsScore);
    }

    public List<Student> findStudentsByNameContainingIgnoreCase(String name) {
        return studentRepo.findByNameContainingIgnoreCase(name);
    }


}

package tdtu.edu.Lab7_5.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.Lab7_5.Repository.StudentRepository;
import tdtu.edu.Lab7_5.model.Student;

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

    public List<Student> greaterOrEqual(int age) {
        return studentRepo.findStudentsByAge(age);
    }

    public long countIelts(double ielts) {
        return studentRepo.countByIelts(ielts);
    }

    public List<Student> findByName(String name) {
        return studentRepo.findByName(name);
    }


}

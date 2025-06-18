package hei.shool.atelier.Service;

import hei.shool.atelier.Model.Student;
import hei.shool.atelier.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }
}

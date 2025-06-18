package hei.shool.atelier.Controller;

import hei.shool.atelier.Model.Student;
import hei.shool.atelier.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;
    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }
    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }
    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return service.getStudentById(id);
    }
    @PostMapping
    public void addStudent(@RequestBody Student student) {
        service.addStudent(student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
    }
}

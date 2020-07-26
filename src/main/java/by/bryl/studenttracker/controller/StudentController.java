package by.bryl.studenttracker.controller;

import by.bryl.studenttracker.entity.Student;
import by.bryl.studenttracker.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Controller for {@link Student}'s pages.
 *
 * @author Andrew Bryl
 */

@Controller
@RequestMapping("/student")
public class StudentController {

    private IStudentService studentService;

    @Autowired
    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String showStudents(Model model) {
        List<Student> studentList = studentService.getStudents();
        model.addAttribute("students", studentList);
        return "student-list";
    }

}

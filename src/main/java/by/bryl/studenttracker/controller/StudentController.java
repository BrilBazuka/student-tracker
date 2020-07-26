package by.bryl.studenttracker.controller;

import by.bryl.studenttracker.entity.Student;
import by.bryl.studenttracker.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "add-student-form";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/student/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int id, Model model) {
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update-student-form";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") int id) {
        studentService.deleteStudent(id);
        return "redirect:/student/list";
    }

    @GetMapping("/search")
    public String search(@ModelAttribute("searchName") String name, Model model) {
        List<Student> students = studentService.searchStudents(name);
        model.addAttribute("students", students);
        return "student-list";
    }
}

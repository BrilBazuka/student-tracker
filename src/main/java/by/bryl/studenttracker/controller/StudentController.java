package by.bryl.studenttracker.controller;

import by.bryl.studenttracker.entity.Student;
import by.bryl.studenttracker.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
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

    // removes leading and trailing whitespace
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

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

    @PostMapping("/saveStudent")
    public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return student.getId() != 0 ? "update-student-form" : "add-student-form";
        } else {
            studentService.save(student);
            return "redirect:/student/list";
        }
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

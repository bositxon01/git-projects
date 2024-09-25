package git;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student(
                "John", "Stones",
                LocalDate.of(2000, 2, 4),
                new String[]{"Football", "Tennis"});

        Student student2 = new Student(
                "Anna", "Polina",
                LocalDate.of(2001, 10, 7),
                new String[]{""});

        StudentService studentService = new StudentService();
        studentService.add(student1);
        studentService.add(student2);
        studentService.add(student1);

        studentService.edit(student1, "John", "Brian");
    }
}

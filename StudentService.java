package git;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentService {
    List<Student> students = new ArrayList<>();

    public boolean add(Student newStudent) {
        for (Student student : students) {
            if (newStudent.compareTo(student) == 0) {
                System.out.println("Student already exists!");
                return false;
            }
        }
        students.add(newStudent);
        System.out.println("Student added successfully");
        return true;
    }

    public boolean edit(Student newStudent, String name, String surname) {
        for (Student student : students) {
            if (newStudent.compareTo(student) == 0) {
                student.setName(name);
                student.setSurname(surname);
                System.out.println("Student edited successfully!");
                return true;
            }
        }
        return false;
    }

    public boolean delete(Student newStudent) {
        for (Student student : students) {
            if (Objects.equals(newStudent, student)) {
                students.remove(newStudent);
                System.out.println("Student removed successfully!");
                return true;
            }
        }
        return false;
    }
}

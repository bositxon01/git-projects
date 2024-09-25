package git;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String[] hobbies;

    public Student(String name, String surname, LocalDate birthdate, String[] hobbies) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        int nameComparison = this.name.compareTo(o.name);

        if (nameComparison == 0) {
            return this.surname.compareTo(o.surname);
        }
        return nameComparison;
    }
}

package by.bsuir.aiprp.ejb.app;

import by.bsuir.aiprp.ejb.model.Student;

import javax.ejb.Stateful;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateful
public class EJB_LAB implements EJB_LABRemote, Serializable {

    private static final long serialVersionUID = 1L;

    private String fio;
    private String department;
    private String group;

    private static final List<Student> students = new ArrayList<>(Arrays.asList(
            new Student("ivanov", "Marketing", "10"),
            new Student("petrov", "Marketing", "14"),
            new Student("sidorov", "Professor", "12"),
            new Student("mishin", "Smith", "12"),
            new Student("vasin", "Programmer", "10")));

    public EJB_LAB() {
    }

    public EJB_LAB(String fio, String department, String group) {
        this.fio = fio;
        this.department = department;
        this.group = group;
    }

    @Override
    public Optional<Student> getStudInfo(String fio) {
        return students.stream()
                .filter(student -> student.getFio().equals(fio))
                .findFirst();
    }

    @Override
    public List<Student> allStudents() {
        return students;
    }

    @Override
    public List<Student> studentsFromDepartment(String department) {
        return students.stream()
                .filter(student -> student.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    @Override
    public long countOfStudentsByGroup(String group) {
        return students.stream()
                .filter(student -> student.getGroup().equals(group))
                .count();
    }

    @Override
    public String addStudent() {
        Student std = new Student(fio, department, group);
        students.add(std);
        return std.getFio();
    }

    @Override
    public String deleteStud(Student em) {
        students.remove(em);
        return em.getFio();
    }
}
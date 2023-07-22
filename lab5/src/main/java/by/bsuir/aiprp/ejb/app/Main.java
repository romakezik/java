package by.bsuir.aiprp.ejb.app;

import by.bsuir.aiprp.ejb.model.Student;

import javax.ejb.EJB;
import java.util.Optional;

@SuppressWarnings("ALL")
public class Main {
    @EJB
    private static final EJB_LABRemote eJB_LAB = new EJB_LAB();

    public static void main(String[] args) {
        addingStudent("andreev", "Marketing", "16");
        allStudents();
        countOfStudentsFromGroup("10");
        studentsFromDepartment("Marketing");
    }

    private static void addingStudent(String fio, String department, String group) {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.print("Student after adding: ");
        Optional<Student> student = eJB_LAB.getStudInfo(
                new EJB_LAB(fio, department, group).addStudent());
        if (student.isPresent()) {
            System.out.println(student.get().toString());
            removingStudent(fio);
        }
    }

    private static void removingStudent(String fio) {
        Optional<Student> student = eJB_LAB.getStudInfo(eJB_LAB.deleteStud(eJB_LAB.getStudInfo(fio).get()));
        System.out.print("Student after delete: ");
        if (student.isPresent()) {
            System.out.println(student.get().toString());
        } else {
            System.out.println("not found");
        }
    }

    private static void allStudents() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("All students:");
        for (Student student : eJB_LAB.allStudents()) {
            System.out.println(student.toString());
        }
    }

    private static void countOfStudentsFromGroup(String group) {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Count of student from '" + group + "' group = "
                + eJB_LAB.countOfStudentsByGroup(group));
    }

    private static void studentsFromDepartment(String department) {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Students from '" + department + "' department:");
        for (Student student : eJB_LAB.studentsFromDepartment(department)) {
            System.out.println(student.toString());
        }
        System.out.print("-----------------------------------------------------------------------------");
    }
}

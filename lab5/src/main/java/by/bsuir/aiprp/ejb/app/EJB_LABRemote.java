package by.bsuir.aiprp.ejb.app;

import by.bsuir.aiprp.ejb.model.Student;

import javax.ejb.Remote;
import java.util.List;
import java.util.Optional;

@Remote
public interface EJB_LABRemote {
    Optional<Student> getStudInfo(String fio);

    String addStudent();

    String deleteStud(Student em);

    List<Student> allStudents();

    List<Student> studentsFromDepartment(String department);

    long countOfStudentsByGroup(String group);
}

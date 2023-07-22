package by.bsuir.aiprp.ejb.model;

public class Student {
    private final String fio;
    private final String department;
    private final String group;

    public Student(String fio, String department, String group) {
        this.fio = fio;
        this.department = department;
        this.group = group;
    }

    public String getFio() {
        return fio;
    }

    public String getDepartment() {
        return department;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fio='" + fio + '\'' +
                ", department='" + department + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StudentController {
    private List<Student> students;

    public StudentController() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void sortStudentsByName() {
        Collections.sort(students, (s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
    }
}

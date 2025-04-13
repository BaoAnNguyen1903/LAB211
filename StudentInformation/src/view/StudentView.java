import java.util.List;

class StudentView {
    public void displayStudentInfo(List<Student> students) {
        int studentCount = 1;
        for (Student student : students) {
            System.out.println("-------------Student " + studentCount + "-------------");
            System.out.println("Name: " + student.getName());
            System.out.println("Classes: " + student.getClasses());
            System.out.println("Mark: " + student.getMark());
            studentCount++;
        }
    }
}
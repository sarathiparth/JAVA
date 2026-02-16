package scenario;
import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private List<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (double g : grades) {
            sum += g;
        }
        return sum / grades.size();
    }

    public void displayStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + calculateAverage());
        System.out.println("----------------------");
    }
}

class GradeManager {
    private List<Student> students;

    public GradeManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudentByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student s : students) {
            s.displayStudentDetails();
        }
    }
}

public class grade {
    public static void main(String[] args) {
        GradeManager manager = new GradeManager();

        Student s1 = new Student("Amit");
        s1.addGrade(85);
        s1.addGrade(90);
        s1.addGrade(88);

        Student s2 = new Student("Neha");
        s2.addGrade(75);
        s2.addGrade(80);
        s2.addGrade(70);

        manager.addStudent(s1);
        manager.addStudent(s2);

        manager.displayAllStudents();

        Student found = manager.findStudentByName("Amit");
        if (found != null) {
            found.displayStudentDetails();
        } else {
            System.out.println("Student not found");
        }
    }
}

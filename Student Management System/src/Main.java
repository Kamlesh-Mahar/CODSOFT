import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNumber=" + rollNumber +
                ", grade='" + grade + '\'' +
                '}';
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        return students.stream()
                .filter(student -> student.getRollNumber() == rollNumber)
                .findFirst()
                .orElse(null);
    }

    public void displayAllStudents() {
        students.forEach(System.out::println);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner, studentManagementSystem);
                    break;
                case 2:
                    removeStudent(scanner, studentManagementSystem);
                    break;
                case 3:
                    searchStudent(scanner, studentManagementSystem);
                    break;
                case 4:
                    studentManagementSystem.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting. Thank you!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    private static void addStudent(Scanner scanner, StudentManagementSystem studentManagementSystem) {
        System.out.print("Enter student name: ");
        scanner.nextLine(); // Consume the newline character
        String name = scanner.nextLine();

        System.out.print("Enter student roll number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter student grade: ");
        String grade = scanner.next();

        Student student = new Student(name, rollNumber, grade);
        studentManagementSystem.addStudent(student);
        System.out.println("Student added successfully!");
    }

    private static void removeStudent(Scanner scanner, StudentManagementSystem studentManagementSystem) {
        System.out.print("Enter student roll number to remove: ");
        int rollNumber = scanner.nextInt();
        studentManagementSystem.removeStudent(rollNumber);
        System.out.println("Student removed successfully!");
    }

    private static void searchStudent(Scanner scanner, StudentManagementSystem studentManagementSystem) {
        System.out.print("Enter student roll number to search: ");
        int rollNumber = scanner.nextInt();
        Student student = studentManagementSystem.searchStudent(rollNumber);

        if (student != null) {
            System.out.println("Student found: " + student);
        } else {
            System.out.println("Student not found.");
        }
    }
}

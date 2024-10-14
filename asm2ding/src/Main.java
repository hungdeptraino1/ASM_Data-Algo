import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.print("\n0: View \n1: Add Student \n2: Remove Student \n3: Sort by Grade \n4: Search Student\n5: Search Grade \nthe rest: Exit \n");
            System.out.print("\nEnter: ");
            
            int input = scanner.nextInt();
            if (input == 0)
            {
                printStudent();
            }
            else if (input == 1)
            {
                addStudent();
            }
            else if (input == 2)
            {
                removeStudent();
            }
            else if (input == 3)
            {
                sortByGrade();
            }
            else if (input == 4)
            {
                searchStudent();
            }
            else if (input == 5)
            {
                searchGrade();
            }
            else
            {
                System.out.println("Exit Program.");
                return;
            }
        }
    }

    public static void addStudents() {
        System.out.println("\nNumber of students: ");
        int num = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < num; ++i) {
            addStudent();
        }
        System.out.println("\nAdded " + num + " students successfully!");
    }

    public static void addStudent() {
        scanner.nextLine(); // Đọc dòng trống trước khi bắt đầu nhập liệu mới
        System.out.print("\n"+"Enter Student Code: ");
        String code = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng trống sau khi nhập số nguyên
        System.out.print("Enter Gender(0 for Male/1 for Female): ");
        int gender = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng trống sau khi nhập số nguyên
        System.out.print("Enter Student's Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Student's Grade: ");
        Double grade = scanner.nextDouble();
        scanner.nextLine(); // Đọc dòng trống sau khi nhập số thực
        Student student = new Student(code, name, age, gender, address, grade);
        studentList.add(student);
    }

    public static void removeStudents() {
        System.out.println("Number of students to remove: ");
        int num = scanner.nextInt();
        if (num <= Student.count) {
            for (int i = 0; i < num; ++i) {
                removeStudent();
            }
        } else {
            System.out.println("Please enter a smaller number!");
        }
    }

    public static void removeStudent() {
        scanner.nextLine(); // Consume newline
        System.out.print("\nEnter the Student Code to remove: ");
        String code = scanner.nextLine();
        boolean removed = studentList.removeIf(student -> student.getCode().equals(code));
        if (removed) {
            System.out.println("\nStudent with code " + code + " has been removed.");
        } else {
            System.out.println("\nNo student found with code " + code);
        }
    }

    public static void sortByGrade() {
        studentList.sort(Comparator.comparing(Student::getGrade).reversed());
        printStudent();
    }

    public static void searchStudent() {
        scanner.nextLine(); // Consume newline
        System.out.print("\nEnter the Student Code/Name to search: ");
        String search = scanner.nextLine();
        List<Student> foundStudents = new ArrayList<>();

        for (Student student : studentList) {
            if (student.getName().equalsIgnoreCase(search) || student.getCode().equalsIgnoreCase(search)) {
                foundStudents.add(student);
            }
        }

        if (foundStudents.isEmpty()) {
            System.out.println("\nNo student found!");
        } else {
            for (Student student : foundStudents) {
                System.out.println(student);
            }
        }
    }

    public static void searchGrade() {
        scanner.nextLine(); // Consume newline
        System.out.print("\nEnter the Grade to search: ");
        Double searchGrade = scanner.nextDouble();
        List<Student> foundStudents = new ArrayList<>();

        for (Student student : studentList) {
            if (student.getGrade().equals(searchGrade) || student.getGrade() > searchGrade) {
                foundStudents.add(student);
            }
        }

        if (foundStudents.isEmpty()) {
            System.out.println("\nNo student found!");
        } else {
            for (Student student : foundStudents) {
                System.out.println(student);
            }
        }
    }

    public static void printStudent() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}


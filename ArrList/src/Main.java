import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static StudentList list = new StudentList();

    public static void main(String[] args) {

        while (true) {
            System.out.println(
                    "\nMenu\n-_________- \n0: Student information \n1: Add Student \n2: Edit Student \n3: Delete Student \n4: Sort Student \n5: Search Student \n6: Exit \n-_________-");
            System.out.print("Enter your choice: ");
            int input = sc.nextInt();
            switch (input) {
                case 0:
                    list.printList();
                case 1:
                    System.out.print("Enter number of student: ");
                    int numStu = 0;
                    while (numStu <=0){
                        while (!sc.hasNextInt()) {
                            System.out.print("Invalid input. Please enter a valid integer value for the number of students: ");
                            sc.next(); // Consume invalid input
                        }
                        numStu = sc.nextInt();
                        if (numStu <= 0) {
                            System.out.print("Number of students must be greater than 0. Please enter a valid number: ");
                        }
                    }
                    for(int i = 0; i < numStu; i++){
                        addStudent();
                    }
                    break;
                case 2:
                    System.out.println("Edit");
                    editStudent();

                case 3:
                    System.out.println("Delete");
                    System.out.println("Index of StudentId in the list:");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("Index: " + i);
                    }
                    deleteStudent();
                    break;
                case 4:
                    System.out.println("Sort");
                    sortStudent();
                case 5:
                    System.out.println("Search");
                    searchStudent();
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static void addStudent(){

        System.out.print("Enter Student Id: ");
        String studentId = sc.nextLine();
        sc.nextLine(); // tieu thu ky tu xuong dong con lai

        System.out.print("Enter Student name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Student marks: ");
        double studentMarks = 0;
        while (true) {
            if (sc.hasNextDouble()) {
                studentMarks = sc.nextDouble();
                if (studentMarks >= 0 && studentMarks <= 10) {
                    break; // Valid marks entered
                } else {
                    System.out.println("Invalid marks. Please enter a value between 0 and 10:");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid double value for marks.");
                sc.nextLine(); // xoa bo dem dau vao
            }
        }
        sc.nextLine(); // tieu thu ky tu xuong dong con lai sau khi doc gia tri double

        Student student = new Student(studentId, studentName, studentMarks);

        if (!list.contain(student)) {
            list.add(student);
        } else {
            System.out.println("Student with this ID already exists.");
        }
    }


    static void editStudent() {
        System.out.println("Enter Student Id to edit: ");
        String studentIdtoedit = sc.nextLine();

        System.out.println("Enter new Id: ");
        String newId = sc.nextLine();

        System.out.println("Ejnter new Name: ");
        String newName = sc.nextLine();

        System.out.println("Enter new Marks: ");
        double newMarks = sc.nextDouble();

        Student editedStudent = new Student(newId, newName, newMarks);

        list.edit(studentIdtoedit, newId, newName, newMarks);
        System.out.println("Student with Id " + studentIdtoedit + " has been edited.");

    }

    static void deleteStudent(){
        int index = sc.nextInt();
        list.delete(index);
        System.out.println("Student at index " + index + "has been deleted.");
    }

    static void sortStudent(){
        int n = list.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).getMarks() > list.get(j + 1).getMarks()) {
                    Student temp = list.get(j);
                    list.set(j, StudentList.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setStudentRank(i + 1);
            list.get(i).getRank();
        }

        System.out.println("Students sorted by marks:");
        System.out.println("-_________-");
        for (Student student : list) {
            System.out.println("Student ID: " + student.getStudentid() + ", Name: " + student.getName() + ", Marks: "
                    + student.getMarks() + ", Rank: " + student.getStudentRank());
        }
    }

    static void searchStudent(){
        sc.nextLine();
        System.out.println("-_________-");
        list.printList();
        System.out.print("Enter Student Id to search: ");
        String studentId = sc.nextLine();

        boolean studentFound = false;
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if (student.getStudentid().equals(studentId)) {
                System.out.println("Student found:");
                System.out.println("Id: " + student.getStudentid() + "\nName: " + student.getName() + "\nMarks: "
                        + student.getMarks());
                studentFound = true;
                break;
            }
        }
        if (!studentFound) {
            System.out.println("Student not found.");
        }
    }

}



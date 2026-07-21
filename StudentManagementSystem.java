import java.util.Scanner;
import java.util.ArrayList;

public class StudentManagementSystem {
    public static String getValidName(Scanner sc) {
        String name;
        do {
            System.out.print("Enter Name: ");
            name = sc.nextLine().trim();
            if(name.isEmpty()) {
                System.out.println("Name cannot be empty!");
            }
        }
        while(name.isEmpty());
        return name;
    }
    public static String getValidBranch(Scanner sc) {
        String branch;
        do {
            System.out.print("Enter Branch: ");
            branch = sc.nextLine().trim();
            if(branch.isEmpty()) {
                System.out.println("Branch cannot be empty!");
            }
        } while(branch.isEmpty());
        return branch;
    }
    public static double getValidMarks(Scanner sc) {
        double marks;
        do {
            System.out.print("Enter Marks (0-100): ");
            marks = sc.nextDouble();
            if(marks < 0 || marks > 100) {
                System.out.println("Invalid Marks! Please enter marks between 0 and 100.");
            }
        } while(marks < 0 || marks > 100);
        sc.nextLine();
        return marks;
    }
    public static boolean isDuplicateId(ArrayList<Student> students, int id) {
        for(Student s : students) {
            if(s.id == id) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Display Topper");
            System.out.println("7. Calculate Average Marks");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter number of students: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for(int i = 1; i <= n; i++) {
                        System.out.println("\nEnter Student " + i + " Details");
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        if(isDuplicateId(students, id)) {
                            System.out.println("Student ID already exists!");
                            i--;
                            continue;
                        }
                        String name = getValidName(sc);
                        String branch = getValidBranch(sc);
                        double marks = getValidMarks(sc);
                        students.add(new Student(id, name, branch, marks));
                    }
                    System.out.println("Students Added Successfully!");
                    break;
                case 2:
                    if(students.isEmpty()) {
                        System.out.println("No Students Found!");
                    }
                    else {
                        System.out.println("\n====== Student Details ======");
                        for(Student s : students) {
                            s.display();
                        }
                    }
                    break;
                case 3:
                    if(students.isEmpty()) {
                        System.out.println("No Students Found!");
                        break;
                    }
                    System.out.print("Enter Student ID to Search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;
                    for(Student s : students) {
                        if(s.id == searchId) {
                            System.out.println("\n===== Student Found! =====");
                            s.display();
                            found = true;
                            break;
                        }
                    }
                    if(!found) {
                        System.out.println("Student Not Found!");
                    }
                    break;
                case 4:
                    if(students.isEmpty()) {
                        System.out.println("No Students Found!");
                        break;
                    }
                    System.out.print("Enter Student ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    boolean updated = false;
                    for(Student s : students) {
                        if(s.id == updateId) {
                            s.name = getValidName(sc);
                            s.branch = getValidBranch(sc);
                            s.marks = getValidMarks(sc);
                            updated = true;
                            System.out.println("Student Updated Successfully!");
                            break;
                        }
                    }
                    if(!updated) {
                        System.out.println("Student ID Not Found!");
                    }
                    break;
                case 5:
                    if(students.isEmpty()) {
                        System.out.println("No Students Found!");
                        break;
                    }
                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = sc.nextInt();
                    boolean deleted = false;
                    for(int i = 0; i < students.size(); i++) {
                        if(students.get(i).id == deleteId) {
                            students.remove(i);
                            deleted = true;
                            System.out.println("Student with ID "+ deleteId +" deleted successfully!");
                            break;
                        }
                    }
                    if(!deleted) {
                        System.out.println("Student ID Not Found!");
                    }
                    break;
                case 6:
                    if(students.isEmpty()) {
                        System.out.println("No Students Found!");
                        break;
                    }
                    Student topper = students.get(0);
                    for(Student s : students) {
                        if(s.marks > topper.marks) {
                            topper = s;
                        }
                    }
                    System.out.println("\n===== TOPPER DETAILS =====");
                    topper.display();
                    break;
                case 7:
                    if(students.isEmpty()) {
                        System.out.println("No Students Found!");
                        break;
                    }
                    double total = 0;
                    for(Student s : students) {
                        total += s.marks;
                    }
                    double average = total / students.size();
                    System.out.printf("Average Marks = %.2f%n" , average);
                    break;
                case 8:
                    System.out.println("Thank you for using the Student Management System.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while(choice != 8);

        sc.close();
    }
}

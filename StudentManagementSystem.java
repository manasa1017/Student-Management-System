import java.util.Scanner;
import java.util.ArrayList;

public class StudentManagementSystem {

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
            System.out.println("6. Exit");

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
                        boolean exists = false;
                        for(Student s : students) {
                            if(s.id == id) {
                                exists = true;
                                break;
                            }
                        }
                        if(exists) {
                            System.out.println("Student ID already exists!");
                            i--;
                            continue;
                        }
                        String name;
                        do {
                            System.out.print("Enter Name: ");
                            name = sc.nextLine().trim();
                            if(name.isEmpty()) {
                                System.out.println("Name cannot be empty!");
                            }
                        }
                        while(name.isEmpty());
                        String branch;
                        do {
                            System.out.print("Enter Branch: ");
                            branch = sc.nextLine().trim();
                            if(branch.isEmpty()) {
                                System.out.println("Branch cannot be empty!");
                            }
                        }
                        while(branch.isEmpty());
                        double marks;
                        do {
                            System.out.print("Enter Marks (0-100): ");
                            marks = sc.nextDouble();
                            if(marks < 0 || marks > 100) {
                                System.out.println("Invalid Marks! Please enter marks between 0 and 100.");
                            }
                        } while(marks < 0 || marks > 100);
                        sc.nextLine();
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
                    System.out.print("Enter Student ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    boolean updated = false;
                    for(Student s : students) {
                        if(s.id == updateId) {
                            do {
                                System.out.print("Enter New Name: ");
                                s.name = sc.nextLine().trim();
                                if(s.name.isEmpty()) {
                                    System.out.println("Name cannot be empty!");
                                }
                            } while(s.name.isEmpty());
                            do {
                                System.out.print("Enter New Branch: ");
                                s.branch = sc.nextLine().trim();
                                if(s.branch.isEmpty()) {
                                    System.out.println("Branch cannot be empty!");
                                }
                            } while(s.branch.isEmpty());
                            do {
                                System.out.print("Enter New Marks (0-100): ");
                                s.marks = sc.nextDouble();
                                if(s.marks < 0 || s.marks > 100) {
                                    System.out.println("Invalid Marks! Please enter marks between 0 and 100.");
                                }
                            }
                            while(s.marks < 0 || s.marks > 100);
                            sc.nextLine();
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
                    System.out.println("Thank you for using the Student Management System.");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while(choice != 6);

        sc.close();
    }
}

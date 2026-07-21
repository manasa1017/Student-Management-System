import java.util.Scanner;
import java.util.ArrayList;

public class Backup {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        ArrayList<Student>students=new ArrayList<>();
        int choice;
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i=1; i<=n; i++) {
            System.out.println("\nEnter Student " + i + " Details");
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Branch: ");
            String branch = sc.nextLine();
            System.out.print("Enter Marks: ");
            double marks = sc.nextDouble();
            sc.nextLine();
            students.add(new Student(id, name, branch, marks));
        }
        System.out.print("\nEnter Student ID to Search: ");
        int searchId = sc.nextInt();
        boolean found = false;
        for(Student s : students) {
            if(s.id == searchId) {
                System.out.println("\n====Student Found!====");
                s.display();
                found = true;
                break;
            }
        }
        if(!found) {
            System.out.println("Student Not Found!");
        }
        System.out.print("\nEnter Student ID to Update: ");
        int updateId = sc.nextInt();
        sc.nextLine();
        boolean updated = false;
        for(Student s : students) {
            if(s.id == updateId) {
                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();
                System.out.print("Enter New Branch: ");
                s.branch = sc.nextLine();
                System.out.print("Enter New Marks: ");
                s.marks = sc.nextDouble();
                sc.nextLine();
                updated = true;
                System.out.println("Student Updated Successfully!");
                break;
            }
        }
        if(!updated) {
            System.out.println("Student ID Not Found!");
        }
        System.out.print("\nEnter Student ID to Delete: ");
        int deleteId = sc.nextInt();
        boolean deleted = false;
        for(int i = 0; i < students.size(); i++) {
            if(students.get(i).id == deleteId) {
                students.remove(i);
                deleted = true;
                System.out.println("Student with ID "+ deleteId +"Deleted Successfully!");
                break;
            }
        }
        if(!deleted) {
            System.out.println("Student ID Not Found!");
        }

        System.out.println("\n======Student Details======");
        for(Student s : students) {
            s.display();
        }
    }
}


import java.util.Scanner;
import java.util.ArrayList;

public class StudentManagementSystem {
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
        System.out.println("\nStudent Details");
        for(Student s : students) {
            s.display();
        }
    }
}

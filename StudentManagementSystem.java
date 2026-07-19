import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Student s1=new Student();
        Student s2=new Student();
        System.out.print("Enter iD:");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name:");
        String name=sc.nextLine();
        System.out.print("Enter Branch:");
        String branch=sc.next();
        System.out.print("Enter Marks:");
        double marks=sc.nextDouble();
        s1.id=id;
        s1.name=name;
        s1.branch=branch;
        s1.marks=marks;
        s1.display();
        System.out.println();
        System.out.print("Enter 2nd Student ID: ");
        id=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter 2nd Student Name: ");
        name=sc.nextLine();
        System.out.print("Enter 2nd Student Branch: ");
        branch=sc.next();
        System.out.print("Enter 2nd Student Marks: ");
        marks=sc.nextDouble();
        s2.id=id;
        s2.name=name;
        s2.branch=branch;
        s2.marks=marks;
        System.out.println();
        s2.display();
    }
}

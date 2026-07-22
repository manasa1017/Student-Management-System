public class Student {
    int id;
    String name;
    String branch;
    double marks;
    Student(int id, String name, String branch, double marks) {
    this.id = id;
    this.name = name;
    this.branch = branch;
    this.marks = marks;
}
    public void display(){
        System.out.println("---------------------------");
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Branch: "+branch);
        System.out.println("Marks: "+marks);
        String grade;
        if(marks >= 90)
            grade = "A+";
        else if(marks >= 80)
            grade = "A";
        else if(marks >= 70)
            grade = "B";
        else if(marks >= 60)
            grade = "C";
        else if(marks >= 50)
            grade = "D";
        else
            grade = "F";
        System.out.println("Grade : " + grade);
    }
}

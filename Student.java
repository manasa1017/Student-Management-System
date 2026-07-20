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
        System.out.println("Student Details");
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
        System.out.println("Branch: "+branch);
        System.out.println("Marks: "+marks);
    }
}

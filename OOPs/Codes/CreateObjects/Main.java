public class Main {
    public static void main(String[] args) {
        // Default ctor
        // Student A = new Student();
        // A.id = 1;
        // A.age = 14;
        // A.name = "Ranu";
        // A.nos = 5;
        // System.out.println(A.name);
        // System.out.println(A.age);
        // System.out.println(A.id);
        // System.out.println(A.nos);

        // A.bunk();
        // A.study();
        // A.sleep();

        // Parameteresed Ctor
        Student A = new Student(1, 12, "Rahul", 3);
        System.out.println(A.name);
        System.out.println(A.age);
        System.out.println(A.id);
        System.out.println(A.nos);

        A.bunk();
        A.study();
        A.sleep();

        Student B = new Student(1, 12, "Rena", 3);
        Student C = new Student(1, 12, "Ranu", 3);
        Student D = new Student(1, 12, "lokesh", 3);

        // Copy ctor
        // Student B = new Student(A);
        // System.out.println(B.name);
        // System.out.println(B.age);
        // System.out.println(B.id);
        // System.out.println(B.nos);

        // B.study();
    }
}
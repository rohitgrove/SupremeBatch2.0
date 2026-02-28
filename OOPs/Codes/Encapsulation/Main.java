public class Main {
    public static void main(String[] args) {
        // Parameteresed Ctor
        Student A = new Student(1, 12, "Rahul", 3, "Tina");
        // System.out.println(A.name);
        // System.out.println(A.age);
        // System.out.println(A.id);
        // System.out.println(A.nos);

        // System.out.println(A.getName());

        System.out.println(A.getAge());
        A.setAge(100);
        System.out.println(A.getAge());
        
        // A.bunk();
        // A.study();
        // A.sleep();
    }
}
public class Main {
    public static void main(String[] args) {
        // Parameterised Ctor
        Student A = new Student(1, 12, "Rahul", 3, "Tina");
        System.out.println(A.getAge());
        A.setAge(54);
        System.out.println(A.getAge());

        // A.bunk();
        // A.study();
        // A.sleep();
    }
}

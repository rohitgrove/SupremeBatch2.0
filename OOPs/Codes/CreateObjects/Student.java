public class Student {
    // Attributes
    public int id;
    public int age;
    public String name;
    public int nos;

    // Defualt ctor
    public Student() {
        System.out.println("Student Default ctor Called");
    }

    // parameterised ctor
    public Student(int id, int age, String name, int nos) {
        System.out.println("Student Parameterised ctor Called");
        this.id = id;
        this.age = age;
        this.name = name;
        this.nos = nos;
    }

    // copy ctor
    public Student(Student srcobj) {
        System.out.println("Student Copy ctor Called");
        this.id = srcobj.id;
        this.age = srcobj.age;
        this.name = srcobj.name;
        this.nos = srcobj.nos;
    }

    // Methods / Behaviors
    public void study() {
        System.out.println(name + " Studying");
    }

    public void sleep() {
        System.out.println(name + " Sleeping");
    }

    public void bunk() {
        System.out.println(name + " Bunking");
    }
}

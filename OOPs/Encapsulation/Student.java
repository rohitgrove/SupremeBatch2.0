public class Student {
    // Attributes
    private int id;
    private int age;
    private String name;
    private int nos;
    private String gf;

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int a) {
        // extra layer of authantication
        if (age < 100) {
            this.age = a;            
        }
        return;
    }

    // Default ctor
    public Student() {
        System.out.println("Student Default ctor Called");
    }

    // Parameterised Ctor
    public Student(int id, int age, String name, int nos, String gf) {
        System.out.println("Student Parameterised Ctor Called");
        this.id = id;
        this.age = age;
        this.name = name;
        this.nos = nos;
        this.gf = gf;
    }

    // Copy Ctor
    public Student(Student srcobj) { // srcobj -> A
        System.out.println("Student Parameterised Ctor Called");
        this.id = srcobj.id;
        this.age = srcobj.age;
        this.name = srcobj.name;
        this.nos = srcobj.nos;
    }

    // Methods / Behaviours
    public void study() {
        System.out.println(name + " Studying");
    }

    public void sleep() {
        System.out.println(name + " Sleeping");
    }

    public void bunk() {
        System.out.println(name + " Bunking");
    }

    private void gfChatting() {
        System.out.println(name+" Chatting");
    }
}
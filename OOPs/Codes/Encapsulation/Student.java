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

    public void setAge(int age) {
        // extra layer of authantication
        if (age <= 100) {
            this.age = age;
        } else {
            throw new RuntimeException("Age is Not Valid");
        }
    }

    // Defualt ctor
    public Student() {
        System.out.println("Student Default ctor Called");
    }

    // parameterised ctor
    public Student(int id, int age, String name, int nos, String gf) {
        System.out.println("Student Parameterised ctor Called");
        this.id = id;
        this.age = age;
        this.name = name;
        this.nos = nos;
        this.gf = gf;
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

    private void gfChatting() {
        System.out.println(name + " Chatting with gf " + gf);
    }
}

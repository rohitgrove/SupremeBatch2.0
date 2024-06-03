class Name {
    String firstName;
    String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

class Person implements Cloneable {
    String id;
    Name name;

    public Person(String id, Name name) {
        this.id = id;
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // This performs a shallow copy
    }
}

public class ShallowCopy {
    public static void main(String[] args) {
        try {
            Name name = new Name("John", "Doe");
            Person original = new Person("1", name);
            Person shallowCopy = (Person) original.clone();

            System.out.println("Original: " + original.name.firstName); // John
            System.out.println("Shallow Copy: " + shallowCopy.name.firstName); // John

            // Modify the name in the original object
            original.name.firstName = "Jane";

            System.out.println("Original after modification: " + original.name.firstName); // Jane
            System.out.println("Shallow Copy after modification: " + shallowCopy.name.firstName); // Jane
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

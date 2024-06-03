class Name {
    String firstName;
    String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Name(this.firstName, this.lastName);
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
        Person deepCopy = (Person) super.clone();
        deepCopy.name = (Name) this.name.clone(); // This performs a deep copy
        return deepCopy;
    }
}

public class DeepCopy {
    public static void main(String[] args) {
        try {
            Name name = new Name("John", "Doe");
            Person original = new Person("1", name);
            Person deepCopy = (Person) original.clone();

            System.out.println("Original: " + original.name.firstName); // John
            System.out.println("Deep Copy: " + deepCopy.name.firstName); // John

            // Modify the name in the original object
            original.name.firstName = "Jane";

            System.out.println("Original after modification: " + original.name.firstName); // Jane
            System.out.println("Deep Copy after modification: " + deepCopy.name.firstName); // John
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

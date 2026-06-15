public class Main {
    public static void main(String[] args) {
        // inner class
        Animal a = new Animal() {
            @Override
            public void sound() {
                System.out.println("Bark");
            }
        };

        a.sound();

        // lambda expression
        // Animal a = () -> {
        //     System.out.println("Bark");
        // };

        // a.sound();
    }
}
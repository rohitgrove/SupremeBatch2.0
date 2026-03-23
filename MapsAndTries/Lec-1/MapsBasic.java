import java.util.HashMap;

public class MapsBasic {
    public static void main(String[] args) {
        // creation
        HashMap<String, Integer> mapping = new HashMap<>();

        // insertion
        mapping.put("Rohit", 25);
        mapping.put("Aman", 24);
        mapping.put("Arun", 21);

        System.out.println("Size of map: " + mapping.size());
        System.out.println(mapping.get("Rohit"));

        mapping.put("Grover", 12);
        System.out.println(mapping.containsKey("Rohit"));

        System.out.println("Size of map: " + mapping.size());

        if (mapping.containsKey("Grover")) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
        System.out.println("Size of map: " + mapping.size());
        System.out.println(mapping.getOrDefault("kumar", 0));
        System.out.println("Size of map: " + mapping.size());
    }
}

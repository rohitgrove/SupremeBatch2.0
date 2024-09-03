import java.util.HashMap;

public class HashMapBasic {
    public static void main(String[] args) {
        // Creation
        HashMap<String, Integer> mapping = new HashMap<>();

        // insertion
        mapping.put("love", 21);
        mapping.put("dipansh", 24);

        mapping.put("arun", 26);

        System.out.println("Size of Map: " + mapping.size());

        // Access
        System.out.println(mapping.get("love"));

        System.out.println(mapping.containsKey("love"));

        if (mapping.containsKey("love")) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }

        System.out.println(mapping.get("Kumar"));
        System.out.println("Size of map: " + mapping.size());
        System.out.println(mapping);
    }
}
import java.util.Arrays;
import java.util.Comparator;

public class CustomComparator {
    public static void main(String[] args) {
        // Create an array of integers
        Integer[] numbers = {5, 3, 8, 1, 9};

        // Print the original array
        System.out.println("Original array:");
        System.out.println(Arrays.toString(numbers));

        // Sort the array using the custom comparator
        Arrays.sort(numbers, new CustomComparatorex());

        // Print the sorted array
        System.out.println("\nSorted array:");
        System.out.println(Arrays.toString(numbers));
    }
}

// Define a custom comparator for sorting integers in descending order. there remove <Integer> parameter when we write on int data type
class CustomComparatorex implements Comparator<Integer> {
    // in function we write Integer Ki jagah object likhna ha
    @Override
    public int compare(Integer num1, Integer num2) {
        // Reverse order comparison for descending sort. we can write in int also. example: className.varibleName - className.varibleName;
        return num2 - num1;
        // return num2.compareTo(num2);
    }
}
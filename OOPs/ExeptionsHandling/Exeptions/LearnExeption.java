package Exeptions;

public class LearnExeption {
    public static void main(String[] args) {
        // int a = 5/0;
        // int arr[] = new int[5];
        // System.out.println(arr[100]);
        System.out.println("Before");
        try {
            // int a = 5 / 0;
            // int arr[] = new int[5];
            // System.out.println(arr[100]);
            System.out.println("Hello");
        } catch (Exception err) {
            System.out.println(err.getMessage());
            System.out.println("we need to Excetion here");
        } finally {
            System.out.println("Main toh execute hoke hi rhe hunga");
        }

        System.out.println("After");
    }
}
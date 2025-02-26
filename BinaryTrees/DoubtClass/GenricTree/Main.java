import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GenricTree gt = new GenricTree();
        Scanner scanner = new Scanner(System.in);
        Node root = gt.takeInput(scanner);
        gt.levelOrderPrint(root);
    }
}

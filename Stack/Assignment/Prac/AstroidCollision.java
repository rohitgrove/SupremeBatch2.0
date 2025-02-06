import java.util.Stack;

public class AstroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int ast : asteroids) {
            boolean destroy = false;
            if (ast > 0) {
                st.push(ast);
            } else {
                if (st.isEmpty() || st.peek() < 0) {
                    st.push(ast);
                } else if (st.peek() > 0) {
                    while (!st.isEmpty() && st.peek() > 0) {
                        if (Math.abs(ast) == st.peek()) {
                            destroy = true;
                            st.pop();
                            break;
                        } else if (Math.abs(ast) > st.peek()) {
                            st.pop();
                        } else {
                            destroy = true;
                            break;
                        }
                    }
                    if (!destroy) {
                        st.push(ast);
                    }
                }
            }
        }

        int ans[] = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int asteroids1[] = { 5, 10, -5 };
        printArr(asteroidCollision(asteroids1));
        int asteroids2[] = { 8, -8 };
        printArr(asteroidCollision(asteroids2));
        int asteroids3[] = { 10, 2, -5 };
        printArr(asteroidCollision(asteroids3));
    }
}

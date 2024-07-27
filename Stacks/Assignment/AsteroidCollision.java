import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int ast : asteroids) {
            boolean destroy = false;
            if (ast > 0) { // initall nothing is destroyed
                st.push(ast);
            } else {
                // -ve
                if (st.empty() || (st.peek() < 0)) {
                    st.push(ast);
                } else {
                    // collision
                    while (!st.empty() && st.peek() > 0) {
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

    public static void printArr(int astroids[]) {
        for (int i = 0; i < astroids.length; i++) {
            System.out.print(astroids[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int asteroids[] = { 5, 10, -5 };
        printArr(asteroids);
        asteroids = asteroidCollision(asteroids);
        printArr(asteroids);
    }
}

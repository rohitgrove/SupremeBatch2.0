import java.util.Stack;

public class BrowserHistory {
    Stack<String> browserStack = new Stack<>();
    Stack<String> fwdStack = new Stack<>();
    
    public BrowserHistory(String homepage) {
        browserStack.push(homepage);
    }
    
    public void visit(String url) {
        // Clear all forward history
        while (!fwdStack.empty()) {
            fwdStack.pop();
        }
        browserStack.push(url);
    }
    
    public String back(int steps) {
        while (steps-- > 0) {
            // Move one step back
            if (browserStack.size() > 1) {
                fwdStack.push(browserStack.pop());
            } else {
                // Only homepage is present, back not possible
                break;
            }
        }
        return browserStack.peek();
    }
    
    public String forward(int steps) {
        while (steps-- > 0) {
            if (!fwdStack.isEmpty()) {
                browserStack.push(fwdStack.pop());
            } else {
                break;
            }
        }
        return browserStack.peek();
    }
}

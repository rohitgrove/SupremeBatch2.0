import java.util.Stack;

public class BrowserHistory {
    Stack<String> browserStack = new Stack<>();
    Stack<String> fwdStack = new Stack<>();

    public BrowserHistory(String homepage) {
        browserStack.push(homepage);
    }

    public void visit(String url) {
        // let's clear all fwd history
        while (!fwdStack.isEmpty()) {
            fwdStack.pop();
        }
        browserStack.push(url);

    }

    public String back(int steps) {
        while (steps-- > 0) {
            // ek baar back jayenge
            if (browserStack.size() > 1) {
                fwdStack.push(browserStack.pop());
            } else {
                // only homepage us present.
                // back not possible
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

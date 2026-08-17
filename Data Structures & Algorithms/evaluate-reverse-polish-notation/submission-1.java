class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();

        for (String s : tokens) {
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                Integer num2 = Integer.parseInt(stack.pop());
                Integer num1 = Integer.parseInt(stack.pop());
                switch (s) {
                    case "+" -> stack.push((num1 + num2) + "");
                    case "-" -> stack.push((num1 - num2) + "");
                    case "*" -> stack.push((num1 * num2) + "");
                    case "/" -> stack.push((num1 / num2) + "");
                }
            } else {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

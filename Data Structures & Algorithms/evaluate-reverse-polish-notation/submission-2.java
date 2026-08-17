class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();

        for (String s : tokens) {
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                Integer num2 = Integer.parseInt(stack.pop());
                Integer num1 = Integer.parseInt(stack.pop());
                Integer num3=0;
                switch (s) {
                    case "+" -> num3 = num1 + num2;
                    case "-" -> num3 = num1 - num2;
                    case "*" -> num3 = num1 * num2;
                    case "/" -> num3 = num1 / num2;
                }
                stack.push(num3.toString());
            } else {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0'); // handle multi-digit numbers
            } 
            else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } 
            else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } 
            else if (c == '(') {
                // push current result and sign before new expression
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } 
            else if (c == ')') {
                result += sign * number;
                number = 0;

                result *= stack.pop(); // pop sign
                result += stack.pop(); // pop previous result
            }
        }

        // add any remaining number
        if (number != 0) {
            result += sign * number;
        }

        return result;
    }
}

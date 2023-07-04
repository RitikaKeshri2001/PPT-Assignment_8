import java.util.*;
public class Q7_DecodeString {
    public static String decodeString(String s) {
        // stack to store number and string value
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        // k to take number from string to store in numStack
        int k = 0;

        for (char c : s.toCharArray()) {
            // convert '1' to 1
            if (Character.isDigit(c)) {
                k = (k * 10) + (c - '0');
                continue;
            }

            // if [ is present we push it in stringStack
            if (c == '[') {
                numStack.push(k);
                k = 0;
                stringStack.push(String.valueOf(c));
                continue;
            }

            // if not equal to ] we add characters
            if (c != ']') {
                stringStack.push(String.valueOf(c));
                continue;
            }

            // add string till ']'
            StringBuilder temp = new StringBuilder();
            while (!stringStack.peek().equals("["))
                temp.insert(0, stringStack.pop());

            // remove the "["
            stringStack.pop();

            // Get the new string
            StringBuilder replacement = new StringBuilder();
            int count = numStack.pop();
            for (int i = 0; i < count; i++)
                replacement.append(temp);

            // Add it to the stack
            stringStack.push(replacement.toString());
        }
        // final string result
        StringBuilder result = new StringBuilder();
        while (!stringStack.empty()) {
            result.insert(0, stringStack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }
}

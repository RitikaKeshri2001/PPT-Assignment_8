public class Q5_StringCompression {
    public static int compress(char[] chars) {
        int j = 0, count = 1;

        // traverse the array
        for(int i = 1; i < chars.length + 1; ++i) {
            if(i == chars.length || chars[i] != chars[i - 1]) {
                // add the character to array
                chars[j++] = chars[i - 1];

                // if the count of character is greater than 1 only then we write the number
                if(count > 1) {
                    // convert the count to string to add in array
                    String s = count + "";

                    // put the number into array
                    for(int k = 0; k < s.length(); ++k)
                        chars[j++] = s.charAt(k);
                }
                // reinitialize the count
                count = 1;
            } else {
                count++;
            }
        }
        // return the length of array
        return j;
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(compress(chars));
    }
}

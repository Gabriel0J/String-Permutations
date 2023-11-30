import java.util.ArrayList;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        permute("ABC");
        permute("tee");
        permute("cat");
        permute("caat");
    }

    public static void permute(String str) {
        Stack<String> container = new Stack<String>();
        Set<String> permutations = new TreeSet<String>();
        container.push( "+" + str);
        while(!container.isEmpty()) {
            String current = container.pop();
            int length = current.length();
            if (current.charAt(length-1) == '+') {
                permutations.add(current.substring(0,length-1));
            } else {
                int currIndex = current.indexOf("+") + 1;
                while (-1 < currIndex && currIndex < length) {
                    String segment1 = current.substring(0, current.indexOf("+"));
                    String currNum = current.substring(currIndex, currIndex + 1);
                    String segment2 = current.substring(current.indexOf("+"), currIndex);
                    String segment3 = current.substring(currIndex+1);
                    container.push(segment1 + currNum + segment2 + segment3);
                    currIndex++;
                }
            }
        }
        System.out.println(permutations);
    }
}
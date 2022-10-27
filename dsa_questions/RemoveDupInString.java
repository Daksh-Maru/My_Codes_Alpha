import java.util.*;
public class RemoveDupInString {
    public static void main(String[] args) {
        String str = "appnnacollege";
        remDuplicates(str, new boolean[26], new StringBuilder(""), 0);
    }

    public static void remDuplicates(String str, boolean[] map, StringBuilder newStr, int idx) {
        if (idx == str.length()) {
            System.out.println(newStr); 
            return;
        } 
        char curr = str.charAt(idx);
        if (map[curr - 'a'] == true)  {
            remDuplicates(str, map, newStr, idx+1);     // call for next index...  (if character is already present)
        } else {
            map[curr - 'a'] = true;
            remDuplicates(str, map, newStr.append(curr), idx);
        }
    }
    
    //  BRUTE FORCE !!!
    public static String remDuplicates(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i=0; i<sb.length(); i++) {
            for (int j=i+1; j<sb.length(); j++) {
                if (sb.charAt(j) == sb.charAt(i)) sb.deleteCharAt(j);
            }
        }
        return sb.toString();
    }
}
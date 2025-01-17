package Amazon;

import java.util.HashSet;

public class longestSubstring {
    public static void main(String[] args) {
        String str = "abcabcbb";
        HashSet<Character> set = new HashSet<>();
        int count = 0, i = 0;
        while(i < str.length()){
            if(set.contains(str.charAt(i))){
                count = Math.max(count, set.size());
                set.clear();
            }
            set.add(str.charAt(i));
            i++; 
        }
        System.out.println(count);
    }
}

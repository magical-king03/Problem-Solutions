import java.util.*;
public class DNAStorage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            // int n = scanner.nextInt();
            String s = scanner.next();

            // Your code goes here
            String ans = "";
            int i = 0;
            while(i<s.length()){
                String check = s.substring(i, i+2);
                if(check.equals("00")){
                    ans += "A";
                }else if(check.equals("01")){
                    ans += "T";
                }else if(check.equals("10")){
                    ans += "C";
                }else{
                    ans += "G";
                }
                i = i + 2;
            }
            System.out.println(ans);
        }
        scanner.close();
    }    
}

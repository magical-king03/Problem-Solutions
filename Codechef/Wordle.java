import java.util.Scanner;

public class Wordle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            String t1 = sc.next();
            String m = "";
            int i = 0;
            while(i<s.length()){
                if(s.charAt(i) == t1.charAt(i)){
                    m += "G";
                }else{
                    m += "B";
                }
                i++;
            }
            System.out.println(m);
        }
        sc.close();
    }
}

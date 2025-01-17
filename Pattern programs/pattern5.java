public class pattern5 {
    public static void main(String[] args) {
        int n = 4, l = 1;
        int spaces1 = n-l, spaces2 = n-l, j = 1;

        for(int i = 1;i<=n;i++){
            while(spaces1 > 0){
                System.out.print(" ");
                spaces1--;
            }
            for(int k = 1;k<=j;k++){
                System.out.print("*");
            }
            j += 2;
            while(spaces2 > 0){
                System.out.print(" ");
                spaces2--;
            }
            l++;
            spaces1 = n-l;
            spaces2 = n-l;
            System.out.println();
        }


        spaces1 = 0;
        spaces2 = 0;
        j = 2 * n - 1;
        l = n;
        for(int i = 1;i<=n;i++){
            while(spaces1 > 0){
                System.out.print(" ");
                spaces1--;
            }
            for(int k = 1;k<=j;k++){
                System.out.print("*");
            }
            j -= 2;
            while(spaces2 > 0){
                System.out.print(" ");
                spaces2--;
            }
            l--;
            spaces1 = n-l;
            spaces2 = n-l;
            System.out.println();
        }
    }
}

// Output:
//    *   
//   ***
//  *****
// *******

// *******
//  *****
//   ***
//    *
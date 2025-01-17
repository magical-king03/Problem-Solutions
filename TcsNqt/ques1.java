import java.util.*;
class ques1 {

    public static void main(String[] args) {
        // int n = 4;
        // int arr[] = {5, 2, 3, 7};
        // int D = 12;
        // int x = 200;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int D = sc.nextInt();
        int x = sc.nextInt();
        int even = 0, odd = 0;
        for(int i = 0;i<n;i++){
            if(arr[i] % 2 == 0){
                even++;
            }else{
                odd++;
            }
        }
        if(D % 2 == 0){
            System.out.println(odd * x);
        }else{
            System.out.println(even * x);
        }
        sc.close();
    }
}
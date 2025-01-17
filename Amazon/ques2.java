package Amazon;
import java.util.*;
public class ques2 {
    public static void main(String[] args) {
        int temp[] = { 73, 74, 75, 71, 69, 72, 76, 73 };
        // int ans[] = new int[temp.length];
        // for (int i = 0; i < temp.length - 1; i++) {
        //     int j = i + 1;
        //     int count = 1;
        //     while (j < temp.length) {
        //         if (temp[i] < temp[j]) {
        //             ans[i] = count;
        //             break;
        //         } else {
        //             count++;
        //         }
        //         j++;
        //     }
        // }
        int[] results = new int[temp.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[stack.peek()] < temp[i]) {
                results[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        for(int i = 0;i<results.length;i++){
            System.out.print(results[i] + " ");            
        }
    }
}

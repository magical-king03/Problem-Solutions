import java.util.*;
public class ques2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mat[][] = new int[n][n]; 
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                mat[i][j] = sc.nextInt();
            }
        }
        //Transpose the matrix
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                // mat[i][j], mat[j][i] = mat[j][i], mat[i][j];
                // transpose[i][j] = mat[j][i];
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        //Flipping the matrix
        for(int i = 0;i<n;i++){
            int left = 0;
            int right = mat[0].length-1;
            while(left <= right){
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}


// 3
// 1 2 3
// 4 5 6
// 7 8 9
public class pattern6 {
    public static void main(String[] args) {
        int n = 5;
        int cols = n;
        char[][] arr = new char[2*n-1][n];
        int row = 0, col = 0;
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<cols;j++){
                if(row < n && col < n && i>=j && ((count == 0 && i%2==0 && j%2==0) || (count == 1 && i%2!=0 && j%2!=0))){
                    arr[i][j] = '*';
                }else{
                    arr[i][j] = ' ';
                }
            }
            if(count == 0){
                count = 1;
            }else{
                count = 0;
            }
        }
        count = 1;
        for(int i = n;i<=2*n-2;i++){
            for(int j = 0;j<cols-1;j++){
                if(i+j <= 2*n-2 && ((count == 0 && i%2==0 && j%2==0) || (count == 1 && i%2!=0 && j%2!=0))){
                    arr[i][j] = '*';
                }else{
                    arr[i][j] = ' ';
                }
            }
            if(count == 0){
                count = 1;
            }else{
                count = 0;
            }
        }
        
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();

        }
    }
}


// Output:
// *
//   *
// *   *
//   *   *
// *   *   *
//   *   *
// *   *
//   *
// *

// 8501961862
// The Viksit Bharat Quiz Challenge (English)
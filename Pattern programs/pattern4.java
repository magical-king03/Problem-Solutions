public class pattern4{
    public static void main(String[] args) {
        int n = 4;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<=i;j++){                
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){  
                if(i+j <= n-1)  {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }          
            }
            System.out.println();
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){  
                if(i+j >= n-1)  {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }          
            }
            System.out.println();
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){  
                if(j >= i)              
                System.out.print("*");
                else
                System.out.print(" ");
            }
            System.out.println();
        }

        
    }
}

// Output:
// *
// **
// ***
// ****

// ****
// ***
// **
// *

//    *
//   **
//  ***
// ****

// ****
//  ***
//   **
//    *
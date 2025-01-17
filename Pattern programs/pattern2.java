public class pattern2 {
    public static void main(String[] args) {
        int n = 4;
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (i == 0 || j == 0 || i == n - 1 || j == n - 1)
        //             System.out.print("*");
        //         else
        //             System.out.print(" ");
        //     }
        //     System.out.println();
        // }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j <= i; j++) {
        //         if (i == 0 || j == 0 || i == j || i == n - 1 || j == n - 1) {
        //             System.out.print("*");
        //         } else
        //             System.out.print(" ");
        //     }
        //     System.out.println();
        // }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (i + j < n) {
        //             if (i == 0 || j == 0 || i + j == n - 1 || i == n - 1 || j == n - 1) {
        //                 System.out.print("*");
        //             } else
        //                 System.out.print(" ");
        //         } else {
        //             System.out.print(" ");
        //         }
        //     }
        //     System.out.println();
        // }

        int row = 0, col1 = n - 1, col2 = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (2 * n) - 1; j++) {
                if (i == n - 1 || (i == row && j == col1) || (i == row && j == col2)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            row += 1;
            col1 -= 1;
            col2 += 1;
            System.out.println();
        }

        // int row = 0, col1 = 0, col2 = (2 * n) - 2;
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < (2 * n) - 1; j++) {
        //         if (i == 0 || (i == row && j == col1) || (i == row && j == col2)) {
        //             System.out.print("*");
        //         } else {
        //             System.out.print(" ");
        //         }
        //     }
        //     row += 1;
        //     col1 += 1;
        //     col2 -= 1;
        //     System.out.println();
        // }
    }
}

// Output:
// ****
// * *
// * *
// ****

// *
// **
// * *
// ****

// ****
// * *
// **
// *

//    *   
//   * *
//  *   *
// *******

// *******
//  *   * 
//   * *  
//    *   
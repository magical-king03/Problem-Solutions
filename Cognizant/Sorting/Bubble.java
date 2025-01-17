package Sorting;

public class Bubble {
    public static void main(String[] args) {
        int arr[] = {1, 5, 2, 4, 3};
        for(int i = 0;i<arr.length - 1;i++){
            for(int j = i;j<arr.length-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }
}

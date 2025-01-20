package Sorting;

public class Selection {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 2, 5};
        int pos = 0;
        for(int i = 0;i<arr.length-1;i++){
            pos = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j] < arr[pos]){
                    pos = j;
                }
            }
            int temp = arr[pos];
            arr[pos] = arr[i];
            arr[i] = temp;
        }
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
    }
}
